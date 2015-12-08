package com.simpletech.webanalytics.service;

import com.simpletech.webanalytics.model.constant.*;
import com.simpletech.webanalytics.model.entity.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 统计API Service
 * Created by 树朾 on 2015/9/25.
 */
public interface StatisticsService {

    /**
     * Visit|PV|UV|IP - 趋势
     * 获取 idsite网站 在 start-end 的 [小时\日\周\月] [Visit|PV|UV|IP]统计数据
     *
     * @param idsite 网站IDE
     * @param period 时段周期 [时|日|周|月]
     * @param start  开始时间
     * @param end    结束时间
     * @return 统计数据
     */
    List<VisitTrendValue> visitTrend(String idsite, Period period, Date start, Date end);

    /**
     * Visit|PV|UV|IP - 时段
     * 获取 idsite网站 在 start-end 的 [小时\日\周\月] [Visit|PV|UV|IP]统计数据
     *
     * @param idsite 网站IDE
     * @param start  开始时间
     * @param end    结束时间
     * @return 统计数据
     */
    VisitSpanValue visitSpan(String idsite, Date start, Date end);

    /**
     * 页面 - Visit|PV|UV|IP - 趋势
     * 获取 idsite网站 在 start-end 的 [小时\日\周\月] [Visit|PV|UV|IP]统计数据
     *
     * @param idsite 网站IDE
     * @param idurl  页面ID
     * @param period 时段周期 [时|日|周|月]
     * @param start  开始时间
     * @param end    结束时间
     * @return 统计数据
     */
    List<VisitTrendValue> pageTrend(String idsite, String idurl, Period period, Date start, Date end);

    /**
     * 页面 - Visit|PV|UV|IP - 时段
     * 获取 idsite网站 在 start-end 的 [小时\日\周\月] [Visit|PV|UV|IP]统计数据
     *
     * @param idsite 网站IDE
     * @param idurl  页面ID
     * @param start  开始时间
     * @param end    结束时间
     * @return 统计数据
     */
    VisitSpanValue pageSpan(String idsite, String idurl, Date start, Date end);


    /**
     * 访问时间 - 分布 （服务器时间，浏览器时间）
     *
     * @param idsite 网站IDE
     * @param type   时间类型  server-服务器时间|local-浏览器时间
     * @param start  开始时间
     * @param end    结束时间   @return 访问时间
     */
    List<VisitTimeMapValue> visitTimeMap(String idsite, TimeType type, Date start, Date end);

    /**
     * 页面时间 - 分布 （服务器时间，浏览器时间）
     *
     * @param idsite 网站IDE
     * @param idurl  页面ID
     * @param type   时间类型  server-服务器时间|local-浏览器时间
     * @param start  开始时间
     * @param end    结束时间   @return 访问时间
     */
    List<VisitTimeMapValue> pageTimeMap(String idsite, String idurl, TimeType type, Date start, Date end);

    /**
     * 访问页数 - 排行
     * @param idsite 网站IDE
     * @param type   时间类型  server-服务器时间|local-浏览器时间
     * @param map    分布格式 如格式 1,2,6,9 表示分布结果 1,2,3-6,7-9,大于9
     * @param start  开始时间
     * @param end    结束时间   @return 访问时间
     */
    List<MapValue> visitPageMap(String idsite, VisitPageType type, String map, Date start, Date end);

    /**
     * 事件统计-时段
     * 获取 idsite网站 事件 在 start-end 的 时段 统计数据
     *
     * @param idsite 网站ID
     * @param start  开始时间
     * @param end    结束时间
     * @return 事件统计-排行
     */
    EventSpanValue eventSpan(String idsite, Date start, Date end);

    /**
     * 事件统计-排行
     * 获取 idsite网站 事件 在 start-end 的 排行 统计数据
     *
     * @param idsite 网站ID
     * @param start  开始时间
     * @param end    结束时间
     * @param limit  分页限制
     * @param skip   分页起始
     * @return 事件统计-排行
     */
    List<EventNameValue> eventRank(String idsite, Date start, Date end, int limit, int skip);

    /**
     * 事件统计-趋势
     * 获取 idsite网站 事件 在 start-end 的 趋势 统计数据
     *
     * @param idsite 网站ID
     * @param start  开始时间
     * @param end    结束时间
     * @param period 截断周期
     * @return event统计数据
     */
    List<EventTrendValue> eventTrend(String idsite, Period period, Date start, Date end);


    /**
     * 指定 名称name event 趋势数据
     * 获取 idsite网站 事件name 在 start-end 的 [小时\日\周\月] 趋势数据
     *
     * @param idsite 网站ID
     * @param name   事件名称
     * @param start  开始时间
     * @param end    结束时间
     * @param limit  分页限制
     * @param skip   分页起始
     * @param period 截断周期
     * @return event统计数据
     */
    List<EventNameTrendValue> eventNameTrend(String idsite, String name, Period period, Date start, Date end, int limit, int skip);

    /**
     * 指定 名称name event 时段数据
     * 获取 idsite网站 事件name 在 start-end 的 时段数据
     *
     * @param idsite 网站ID
     * @param name   事件名称
     * @param start  开始时间
     * @param end    结束时间
     * @return event统计数据
     */
    EventNameSpanValue eventNameSpan(String idsite, String name, Date start, Date end);

    /**
     * 页面标题排行
     *
     * @param idsite 网站ID
     * @param ranktype 排序类型 按 visit|uv|ip|pv
     * @param start  开始时间
     * @param end    结束时间
     * @param limit  分页限制
     * @param skip   分页起始
     * @return 标题排行
     */
    List<PageValue> titleurl(String idsite, PageRank type, RankingType ranktype, Date start, Date end, int limit, int skip);

    /**
     * 新老用户-趋势
     *
     * @param idsite 网站ID
     * @param start  开始时间
     * @param end    结束时间
     * @return 新老用户
     */
    VisitorSpanValue visitorSpan(String idsite, Date start, Date end);

    /**
     * 新老用户-趋势
     *
     * @param idsite 网站ID
     * @param period 时段周期 [时|日|周|月]
     * @param start  开始时间
     * @param end    结束时间
     * @return 新老用户
     */
    List<VisitorTrendValue> visitorTrend(String idsite, Period period, Date start, Date end);

    /**
     * 站点数据排行
     * 设备品牌、设备型号、网络类型、浏览器、操作系统、APP、分辨率、颜色深度、语言、国家、省份、城市
     *
     * @param ranking  排行类型 brand|model|nettype|browser|system|appname|resolution|depth|lang|country|province|city|ip
     * @param ranktype 排序类型 按 visit|uv|ip|pv
     * @param idsite   网站ID
     * @param start    开始时间
     * @param end      结束时间
     * @param limit    分页限制
     * @param skip     分页起始
     * @return 排行数据
     */
    List<RankingValue> ranking(String idsite, Ranking ranking, RankingType ranktype, Date start, Date end, int limit, int skip);

    /**
     * 页面数据排行
     * 设备品牌、设备型号、网络类型、浏览器、操作系统、APP、分辨率、颜色深度、语言、国家、省份、城市
     *
     * @param ranking  排行类型 brand|model|nettype|browser|system|appname|resolution|depth|lang|country|province|city|ip
     * @param ranktype 排序类型 按 visit|uv|ip|pv
     * @param idsite   网站ID
     * @param idurl    页面ID
     * @param start    开始时间
     * @param end      结束时间
     * @param limit    分页限制
     * @param skip     分页起始
     * @return 排行数据
     */
    List<RankingValue> pageRank(String idsite, String idurl, Ranking ranking, RankingType ranktype, Date start, Date end, int limit, int skip);

    /**
     * 分享传播图点线列表
     *
     * @param idsite   网站ID
     * @param urlId    页面ID
     * @param start    开始时间
     * @param end      结束时间
     * @return 分享图点线列表
     */
    Map<String,Object> shareMap(String idsite, String urlId, Date start, Date end);

    /**
     * 页面分享排行
     *
     * @param idsite   网站ID
     * @param start    开始时间
     * @param end      结束时间
     * @return 页面分享排行
     */
    List<PageRankValue> shareRank(String idsite, Date start, Date end, int limit, int skip);

    /**
     * [入口|出口]页面
     *
     * @param idsite 网站ID
     * @param start  开始时间
     * @param end    结束时间
     * @return  [入口|出口]页面
     */
    List<EnterCloseValue> enterexit(String idsite, EnterExit type, RankingType ranktype, Date start, Date end, int limit, int skip);
}
