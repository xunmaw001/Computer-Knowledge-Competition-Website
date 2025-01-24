const base = {
    get() {
        return {
            url : "http://localhost:8080/jisuanjizhishijingsaiwangzhan/",
            name: "jisuanjizhishijingsaiwangzhan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/jisuanjizhishijingsaiwangzhan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "计算机知识竞赛网站"
        } 
    }
}
export default base
