
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 评委
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pingwei")
public class PingweiController {
    private static final Logger logger = LoggerFactory.getLogger(PingweiController.class);

    private static final String TABLE_NAME = "pingwei";

    @Autowired
    private PingweiService pingweiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private SaishiService saishiService;//赛事
    @Autowired
    private SaishiBaomingService saishiBaomingService;//赛事报名
    @Autowired
    private SaishiCollectionService saishiCollectionService;//赛事收藏
    @Autowired
    private SaishiLiuyanService saishiLiuyanService;//赛事留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("评委".equals(role))
            params.put("pingweiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = pingweiService.queryPage(params);

        //字典表数据转换
        List<PingweiView> list =(List<PingweiView>)page.getList();
        for(PingweiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PingweiEntity pingwei = pingweiService.selectById(id);
        if(pingwei !=null){
            //entity转view
            PingweiView view = new PingweiView();
            BeanUtils.copyProperties( pingwei , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PingweiEntity pingwei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pingwei:{}",this.getClass().getName(),pingwei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<PingweiEntity> queryWrapper = new EntityWrapper<PingweiEntity>()
            .eq("username", pingwei.getUsername())
            .or()
            .eq("pingwei_phone", pingwei.getPingweiPhone())
            .or()
            .eq("pingwei_id_number", pingwei.getPingweiIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingweiEntity pingweiEntity = pingweiService.selectOne(queryWrapper);
        if(pingweiEntity==null){
            pingwei.setCreateTime(new Date());
            pingwei.setPassword("123456");
            pingweiService.insert(pingwei);
            return R.ok();
        }else {
            return R.error(511,"账户或者评委手机号或者评委身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PingweiEntity pingwei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,pingwei:{}",this.getClass().getName(),pingwei.toString());
        PingweiEntity oldPingweiEntity = pingweiService.selectById(pingwei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(pingwei.getPingweiPhoto()) || "null".equals(pingwei.getPingweiPhoto())){
                pingwei.setPingweiPhoto(null);
        }

            pingweiService.updateById(pingwei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PingweiEntity> oldPingweiList =pingweiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        pingweiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PingweiEntity> pingweiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PingweiEntity pingweiEntity = new PingweiEntity();
//                            pingweiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //pingweiEntity.setPassword("123456");//密码
//                            pingweiEntity.setPingweiUuidNumber(data.get(0));                    //评委编号 要改的
//                            pingweiEntity.setPingweiName(data.get(0));                    //评委姓名 要改的
//                            pingweiEntity.setPingweiPhone(data.get(0));                    //评委手机号 要改的
//                            pingweiEntity.setPingweiIdNumber(data.get(0));                    //评委身份证号 要改的
//                            pingweiEntity.setPingweiPhoto("");//详情和图片
//                            pingweiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            pingweiEntity.setPingweiEmail(data.get(0));                    //电子邮箱 要改的
//                            pingweiEntity.setCreateTime(date);//时间
                            pingweiList.add(pingweiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //评委编号
                                if(seachFields.containsKey("pingweiUuidNumber")){
                                    List<String> pingweiUuidNumber = seachFields.get("pingweiUuidNumber");
                                    pingweiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> pingweiUuidNumber = new ArrayList<>();
                                    pingweiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("pingweiUuidNumber",pingweiUuidNumber);
                                }
                                //评委手机号
                                if(seachFields.containsKey("pingweiPhone")){
                                    List<String> pingweiPhone = seachFields.get("pingweiPhone");
                                    pingweiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> pingweiPhone = new ArrayList<>();
                                    pingweiPhone.add(data.get(0));//要改的
                                    seachFields.put("pingweiPhone",pingweiPhone);
                                }
                                //评委身份证号
                                if(seachFields.containsKey("pingweiIdNumber")){
                                    List<String> pingweiIdNumber = seachFields.get("pingweiIdNumber");
                                    pingweiIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> pingweiIdNumber = new ArrayList<>();
                                    pingweiIdNumber.add(data.get(0));//要改的
                                    seachFields.put("pingweiIdNumber",pingweiIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<PingweiEntity> pingweiEntities_username = pingweiService.selectList(new EntityWrapper<PingweiEntity>().in("username", seachFields.get("username")));
                        if(pingweiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PingweiEntity s:pingweiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //评委编号
                        List<PingweiEntity> pingweiEntities_pingweiUuidNumber = pingweiService.selectList(new EntityWrapper<PingweiEntity>().in("pingwei_uuid_number", seachFields.get("pingweiUuidNumber")));
                        if(pingweiEntities_pingweiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PingweiEntity s:pingweiEntities_pingweiUuidNumber){
                                repeatFields.add(s.getPingweiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [评委编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //评委手机号
                        List<PingweiEntity> pingweiEntities_pingweiPhone = pingweiService.selectList(new EntityWrapper<PingweiEntity>().in("pingwei_phone", seachFields.get("pingweiPhone")));
                        if(pingweiEntities_pingweiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PingweiEntity s:pingweiEntities_pingweiPhone){
                                repeatFields.add(s.getPingweiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [评委手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //评委身份证号
                        List<PingweiEntity> pingweiEntities_pingweiIdNumber = pingweiService.selectList(new EntityWrapper<PingweiEntity>().in("pingwei_id_number", seachFields.get("pingweiIdNumber")));
                        if(pingweiEntities_pingweiIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PingweiEntity s:pingweiEntities_pingweiIdNumber){
                                repeatFields.add(s.getPingweiIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [评委身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        pingweiService.insertBatch(pingweiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        PingweiEntity pingwei = pingweiService.selectOne(new EntityWrapper<PingweiEntity>().eq("username", username));
        if(pingwei==null || !pingwei.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(pingwei.getId(),username, "pingwei", "评委");
        R r = R.ok();
        r.put("token", token);
        r.put("role","评委");
        r.put("username",pingwei.getPingweiName());
        r.put("tableName","pingwei");
        r.put("userId",pingwei.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody PingweiEntity pingwei, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<PingweiEntity> queryWrapper = new EntityWrapper<PingweiEntity>()
            .eq("username", pingwei.getUsername())
            .or()
            .eq("pingwei_phone", pingwei.getPingweiPhone())
            .or()
            .eq("pingwei_id_number", pingwei.getPingweiIdNumber())
            ;
        PingweiEntity pingweiEntity = pingweiService.selectOne(queryWrapper);
        if(pingweiEntity != null)
            return R.error("账户或者评委手机号或者评委身份证号已经被使用");
        pingwei.setPingweiUuidNumber(String.valueOf(new Date().getTime()));
        pingwei.setCreateTime(new Date());
        pingweiService.insert(pingwei);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        PingweiEntity pingwei = pingweiService.selectById(id);
        pingwei.setPassword("123456");
        pingweiService.updateById(pingwei);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        PingweiEntity pingwei = pingweiService.selectOne(new EntityWrapper<PingweiEntity>().eq("username", username));
        if(pingwei!=null){
            pingwei.setPassword("123456");
            pingweiService.updateById(pingwei);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrPingwei(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        PingweiEntity pingwei = pingweiService.selectById(id);
        if(pingwei !=null){
            //entity转view
            PingweiView view = new PingweiView();
            BeanUtils.copyProperties( pingwei , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = pingweiService.queryPage(params);

        //字典表数据转换
        List<PingweiView> list =(List<PingweiView>)page.getList();
        for(PingweiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PingweiEntity pingwei = pingweiService.selectById(id);
            if(pingwei !=null){


                //entity转view
                PingweiView view = new PingweiView();
                BeanUtils.copyProperties( pingwei , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody PingweiEntity pingwei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,pingwei:{}",this.getClass().getName(),pingwei.toString());
        Wrapper<PingweiEntity> queryWrapper = new EntityWrapper<PingweiEntity>()
            .eq("username", pingwei.getUsername())
            .or()
            .eq("pingwei_phone", pingwei.getPingweiPhone())
            .or()
            .eq("pingwei_id_number", pingwei.getPingweiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingweiEntity pingweiEntity = pingweiService.selectOne(queryWrapper);
        if(pingweiEntity==null){
            pingwei.setCreateTime(new Date());
        pingwei.setPassword("123456");
        pingweiService.insert(pingwei);

            return R.ok();
        }else {
            return R.error(511,"账户或者评委手机号或者评委身份证号已经被使用");
        }
    }

}

