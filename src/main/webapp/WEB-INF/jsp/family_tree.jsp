<%--
  Created by IntelliJ IDEA.
  User: liuw
  Date: 2017/1/19
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<jsp:include page="head.jsp"></jsp:include>
<script src="${ctx}/js/echarts-all.js"></script>
<title>刘氏家谱</title>
</head>
<script>
    $(function () {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        $.ajax(function () {
        });
        option = {
            title : {
                text: 'family tree'
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            series : [
                {
                    name:'树图',
                    type:'tree',
                    orient: 'horizontal',  // vertical horizontal
                    rootLocation: {x: 100, y: 'center'}, // 根节点位置  {x: 100, y: 'center'}
                    nodePadding:50,
                    layerPadding: 200,
                    hoverable: false,
                    roam: true,
                    symbolSize: 10,
                    itemStyle: {
                        normal: {
                            color: '#4883b4',
                            label: {
                                show: true,
                                position: 'right',
                                formatter: "{b}",
                                textStyle: {
                                    color: '#000',
                                    fontSize: 40
                                }
                            },
                            lineStyle: {
                                color: '#ccc',
                                type: 'dashed' // 'curve'|'broken'|'solid'|'dotted'|'dashed'

                            }
                        },
                        emphasis: {
                            color: '#4883b4',
                            label: {
                                show: false
                            },
                            borderWidth: 0
                        }
                    },

                    data: [
                        {"name":"文华","children":[{"name":"辑公","children":[]},{"name":"轴公","children":[{"name":"朝钦","children":[]},{"name":"朝廷","children":[]},{"name":"朝锐","children":[{"name":"元德","children":[{"name":"乾道","children":[{"name":"济云","children":[]},{"name":"济环","children":[]},{"name":"开周","children":[{"name":"齐弼","children":[]},{"name":"辉弼","children":[]},{"name":"擎宵","children":[{"name":"重熀","children":[{"name":"亦韩","children":[{"name":"元镟","children":[{"name":"光激","children":[{"name":"瑞架","children":[{"name":"宗妍","children":[{"name":"明能","children":[{"name":"文伯","children":[]},{"name":"文","children":[]},{"name":"文狗","children":[{"name":"炳粒","children":[{"name":"科联","children":[{"name":"笔山","children":[]},{"name":"顺忠","children":[]},{"name":"顺良","children":[]},{"name":"丁山","children":[]}]},{"name":"会山","children":[{"name":"孙林","children":[{"name":"晖铭","children":[]},{"name":"剑榕","children":[]}]},{"name":"春文","children":[{"name":"威","children":[]}]}]}]}]}]}]}]}]}]}]}]},{"name":"重熺","children":[]}]}]}]}]}]}]},{"name":"轮公","children":[]},{"name":"辅公","children":[]},{"name":"辙公","children":[]}]}
                    ]
                }
            ]
        };



        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });


</script>
<body>
<h1>山后村刘氏家谱</h1>

    <div id="main" style="width: 100%;height:100%;"></div>




</body>
</html>
