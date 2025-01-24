
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
 * 赛事报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishiBaoming")
public class SaishiBaomingController {
    private static final Logger logger = LoggerFactory.getLogger(SaishiBaomingController.class);

    private static final String TABLE_NAME = "saishiBaoming";

    @Autowired
    private SaishiBaomingService saishiBaomingService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private PingweiService pingweiService;//评委
    @Autowired
    private SaishiService saishiService;//赛事
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
        PageUtils page = saishiBaomingService.queryPage(params);

        //字典表数据转换
        List<SaishiBaomingView> list =(List<SaishiBaomingView>)page.getList();
        for(SaishiBaomingView c:list){
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
        SaishiBaomingEntity saishiBaoming = saishiBaomingService.selectById(id);
        if(saishiBaoming !=null){
            //entity转view
            SaishiBaomingView view = new SaishiBaomingView();
            BeanUtils.copyProperties( saishiBaoming , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(saishiBaoming.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "pingweiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 赛事
            //级联表
            SaishiEntity saishi = saishiService.selectById(saishiBaoming.getSaishiId());
            if(saishi != null){
            BeanUtils.copyProperties( saishi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "pingweiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSaishiId(saishi.getId());
            }
            //级联表 评委
            //级联表
            PingweiEntity pingwei = pingweiService.selectById(saishiBaoming.getPingweiId());
            if(pingwei != null){
            BeanUtils.copyProperties( pingwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "pingweiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setPingweiId(pingwei.getId());
            }
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
    public R save(@RequestBody SaishiBaomingEntity saishiBaoming, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishiBaoming:{}",this.getClass().getName(),saishiBaoming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("评委".equals(role))
            saishiBaoming.setPingweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            saishiBaoming.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SaishiBaomingEntity> queryWrapper = new EntityWrapper<SaishiBaomingEntity>()
            .eq("saishi_id", saishiBaoming.getSaishiId())
            .eq("yonghu_id", saishiBaoming.getYonghuId())
            .eq("pingwei_id", saishiBaoming.getPingweiId())
            .eq("saishi_baoming_types", saishiBaoming.getSaishiBaomingTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiBaomingEntity saishiBaomingEntity = saishiBaomingService.selectOne(queryWrapper);
        if(saishiBaomingEntity==null){
            saishiBaoming.setInsertTime(new Date());
            saishiBaoming.setCreateTime(new Date());
            saishiBaomingService.insert(saishiBaoming);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishiBaomingEntity saishiBaoming, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,saishiBaoming:{}",this.getClass().getName(),saishiBaoming.toString());
        SaishiBaomingEntity oldSaishiBaomingEntity = saishiBaomingService.selectById(saishiBaoming.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("评委".equals(role)){
            saishiBaoming.setPingweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            saishiBaoming.setPingshenTime(new Date());
            saishiBaoming.setSaishiBaomingTypes(106);
        }
        if("".equals(saishiBaoming.getSaishiBaomingFile()) || "null".equals(saishiBaoming.getSaishiBaomingFile())){
                saishiBaoming.setSaishiBaomingFile(null);
        }

            saishiBaomingService.updateById(saishiBaoming);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SaishiBaomingEntity> oldSaishiBaomingList =saishiBaomingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        saishiBaomingService.deleteBatchIds(Arrays.asList(ids));

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
            List<SaishiBaomingEntity> saishiBaomingList = new ArrayList<>();//上传的东西
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
                            SaishiBaomingEntity saishiBaomingEntity = new SaishiBaomingEntity();
//                            saishiBaomingEntity.setSaishiBaomingUuidNumber(data.get(0));                    //报名编号 要改的
//                            saishiBaomingEntity.setSaishiId(Integer.valueOf(data.get(0)));   //赛事 要改的
//                            saishiBaomingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            saishiBaomingEntity.setPingweiId(Integer.valueOf(data.get(0)));   //评委 要改的
//                            saishiBaomingEntity.setInsertTime(date);//时间
//                            saishiBaomingEntity.setSaishiBaomingFile(data.get(0));                    //赛事成果 要改的
//                            saishiBaomingEntity.setSaishiBaomingTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            saishiBaomingEntity.setDefen(data.get(0));                    //评审得分 要改的
//                            saishiBaomingEntity.setSaishiBaomingText(data.get(0));                    //评审意见 要改的
//                            saishiBaomingEntity.setPingshenTime(sdf.parse(data.get(0)));          //评审时间 要改的
//                            saishiBaomingEntity.setCreateTime(date);//时间
                            saishiBaomingList.add(saishiBaomingEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("saishiBaomingUuidNumber")){
                                    List<String> saishiBaomingUuidNumber = seachFields.get("saishiBaomingUuidNumber");
                                    saishiBaomingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> saishiBaomingUuidNumber = new ArrayList<>();
                                    saishiBaomingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("saishiBaomingUuidNumber",saishiBaomingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<SaishiBaomingEntity> saishiBaomingEntities_saishiBaomingUuidNumber = saishiBaomingService.selectList(new EntityWrapper<SaishiBaomingEntity>().in("saishi_baoming_uuid_number", seachFields.get("saishiBaomingUuidNumber")));
                        if(saishiBaomingEntities_saishiBaomingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SaishiBaomingEntity s:saishiBaomingEntities_saishiBaomingUuidNumber){
                                repeatFields.add(s.getSaishiBaomingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        saishiBaomingService.insertBatch(saishiBaomingList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = saishiBaomingService.queryPage(params);

        //字典表数据转换
        List<SaishiBaomingView> list =(List<SaishiBaomingView>)page.getList();
        for(SaishiBaomingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaishiBaomingEntity saishiBaoming = saishiBaomingService.selectById(id);
            if(saishiBaoming !=null){


                //entity转view
                SaishiBaomingView view = new SaishiBaomingView();
                BeanUtils.copyProperties( saishiBaoming , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(saishiBaoming.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    SaishiEntity saishi = saishiService.selectById(saishiBaoming.getSaishiId());
                if(saishi != null){
                    BeanUtils.copyProperties( saishi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSaishiId(saishi.getId());
                }
                //级联表
                    PingweiEntity pingwei = pingweiService.selectById(saishiBaoming.getPingweiId());
                if(pingwei != null){
                    BeanUtils.copyProperties( pingwei , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setPingweiId(pingwei.getId());
                }
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
    public R add(@RequestBody SaishiBaomingEntity saishiBaoming, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,saishiBaoming:{}",this.getClass().getName(),saishiBaoming.toString());
        Wrapper<SaishiBaomingEntity> queryWrapper = new EntityWrapper<SaishiBaomingEntity>()
            .eq("saishi_id", saishiBaoming.getSaishiId())
            .eq("yonghu_id", saishiBaoming.getYonghuId())
//            .notIn("saishi_baoming_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiBaomingEntity saishiBaomingEntity = saishiBaomingService.selectOne(queryWrapper);
        if(saishiBaomingEntity==null){
            saishiBaoming.setInsertTime(new Date());
            saishiBaoming.setCreateTime(new Date());
        saishiBaomingService.insert(saishiBaoming);

            return R.ok();
        }else {
            return R.error(511,"该用户已经报名过此赛事,请去赛事报名中查看");
        }
    }

    /**
    * 取消报名
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            SaishiBaomingEntity saishiBaoming = saishiBaomingService.selectById(id);//当前表service
            Integer saishiId = saishiBaoming.getSaishiId();
            if(saishiId == null)
                return R.error(511,"查不到该赛事");
            SaishiEntity saishiEntity = saishiService.selectById(saishiId);
            if(saishiEntity == null)
                return R.error(511,"查不到该赛事");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;






            saishiBaoming.setSaishiBaomingTypes(102);//设置订单状态为已取消报名
            saishiBaomingService.updateById(saishiBaoming);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            saishiService.updateById(saishiEntity);//更新订单中赛事的信息

            return R.ok();
    }

    /**
     * 报名通过
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        SaishiBaomingEntity  saishiBaomingEntity = saishiBaomingService.selectById(id);
        saishiBaomingEntity.setSaishiBaomingTypes(103);//设置订单状态为报名通过
        saishiBaomingService.updateById( saishiBaomingEntity);

        return R.ok();
    }


    /**
     * 提交成果
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        SaishiBaomingEntity  saishiBaomingEntity = saishiBaomingService.selectById(id);
        saishiBaomingEntity.setSaishiBaomingTypes(104);//设置订单状态为提交成果
        saishiBaomingService.updateById( saishiBaomingEntity);
        return R.ok();
    }

}

