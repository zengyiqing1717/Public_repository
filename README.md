<p align="center">
	<img alt="logo" src="https://oscimg.oschina.net/oscnet/up-d3d0a9303e11d522a06cd263f3079027715.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">健身运动记录系统</h1>
<h4 align="center">基于 RuoYi-Vue 二次开发的个人/团队运动数据管理平台</h4>
<p align="center">
	<a href="https://gitee.com/你的用户名/你的仓库名/stargazers"><img src="https://gitee.com/你的用户名/你的仓库名/badge/star.svg?theme=dark"></a>
	<a href="https://gitee.com/你的用户名/你的仓库名"><img src="https://img.shields.io/badge/版本-v1.0.0-brightgreen.svg"></a>
	<a href="https://gitee.com/你的用户名/你的仓库名/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>

## 平台简介

本系统基于 **RuoYi-Vue 前后端分离框架** 二次开发，专为健身爱好者、教练和团队打造。

* 前端采用 Vue + Element UI，界面清爽，移动端友好。
* 后端采用 Spring Boot、Spring Security、Redis & Jwt。
* 支持**运动记录**（跑步、撸铁、瑜伽、骑行等）、**训练计划**、**数据统计**（时长/卡路里/组数）。
* 支持教练发布训练任务、学员打卡，以及社区动态分享。
* 高效率开发：借助 RuoYi 代码生成器，可快速扩展新运动类型或排行榜功能。

## 内置功能（健身定制版）

1.  **用户管理**：普通用户、认证教练、管理员，支持个人信息维护。
2.  **运动记录**：记录每日训练项目、时长、距离、重量/次数/组数、消耗卡路里。
3.  **训练计划**：教练/用户可创建周期计划（如“5公里跑步计划”），并跟踪完成度。
4.  **动作库管理**：预设常见力量训练/有氧动作（深蹲、卧推、波比跳等），支持图文教程。
5.  **数据统计**：周/月/年运动趋势图（热量消耗、训练频次）、个人最好成绩。
6.  **排行榜**：按运动量、打卡天数、减重等维度生成社区或好友榜单。
7.  **社区动态**：用户可发布运动照片、心得，互相点赞评论。
8.  **公告通知**：系统公告、活动通知推送。
9.  **操作日志**：记录用户关键操作（如删除记录、修改计划）。
10. **定时任务**：每日自动计算用户运动总结、发送提醒。
11. **代码生成**：新增运动类型或排行榜时，一键生成前后端代码。
12. **系统监控**：监控服务器状态，保障服务稳定。

## 在线体验（演示地址请更换）

- 演示地址：暂未部署，后续补充  
- 测试账号：`demo` / `123456`（仅限查看）  

文档地址：`http://你的文档地址`

## 技术栈速查

| 后端框架 | Spring Boot 2.x / 3.x   |
| -------- | ----------------------- |
| 安全框架 | Spring Security + Jwt   |
| 数据库   | MySQL + Redis           |
| 前端     | Vue 2 / Vue 3 + Element |
| 构建工具 | Maven / Vite            |

## 项目结构说明（基于 RuoYi-Vue 改造）
