# 基于 MVVM 的家政服务系统（Android）

本仓库提供了一个符合毕设场景的 **MVVM 架构代码骨架**，包含：

- 分层目录（ui/viewmodel/model/network/database/adapter/utils）
- 统一响应模型与核心实体模型
- Retrofit + OkHttp 网络配置
- Room 本地缓存结构
- Repository 的“接口失败自动回退模拟数据”策略
- ViewModel + LiveData 的页面状态管理（加载中/空数据/错误/成功）

## 包结构

```text
com.housekeeping
├── ui
├── viewmodel
├── model
├── network
├── database
├── adapter
└── utils
```

## 已实现关键点

1. **网络失败兜底**：登录、服务列表、订单模块提供 try-catch 兜底逻辑。
2. **统一状态驱动 UI**：通过 `UiState` 封装加载、空、错误、成功四类状态。
3. **本地缓存**：订单缓存与购物车缓存 DAO 已定义。
4. **基础 URL**：默认指向 `http://127.0.0.1:8080/api/`。

## 后续建议

- 补齐 XML 布局并开启 ViewBinding/DataBinding。
- 完善 RecyclerView Adapter 的 ViewHolder 与多状态视图。
- 增加管理员、服务人员、评价模块的接口定义与 Repository 逻辑。
- 添加导航、通知、定位打卡、模拟支付页面流程。
