# configs

### 介绍
> 通用的项目配置管理，包括项目配置文件、工具

### 目录结构

      | -- 根目录
        | -- configs 通用的版本管理，包括项目配置文件、工具
            | -- dependencies 通用依赖库版本管理（子模块）
               | -- config.gradle 通用的项目build构建版本号配置
               | -- dependencies.gradle 通用的项目build构建版本号配置
            | -- tools 项目所需的工具包
               | -- gradle 通用项目配置文件包
                  | -- publish 项目lib发布配置，包括JitPack发布脚本等
                  | -- apk_output.gradle APK 打包配置，包括apk重命名、归档备份
                  | -- app.gradle 通用的 APP build配置，包括解决依赖冲突、分环境分渠道打包、分包、自动签名等
                  | -- check_depx_versions.gradle 检测依赖库最新版本配置
                  | -- common.gradle 通用的项目配置，包括 GIT 提交信息、打包排除文件、静态检查白名单等
                  | -- git.gradle 基于 GIT 进行版本号得到 APP 版本号
                  | -- library.gradle 通用的library库项目配置
               | -- keystore 通用项目签名文件包
               | -- proguard 通用项目混淆文件包

### commit提交模板

    * 【FEAT新增功能】-【新的功能点、新的需求】
    * 【FIXBug修复】-【修复的Bug:现网发散Bug、测试阶段的Bug、验收阶段的Bug】
    * 【DOCS文档修改】-【只是修改了文档:注释、README.md等】.
    * 【STYLE样式修改】-【不影响代码功能的修改:CSS样式、代码格式化等】
    * 【REFACTOR代码重构】-【代码更改既不修复错误也不添加功能】
    * 【PERF性能优化】-【代码更改可以提高性能】
    * 【TEST测试代码】-【添加缺失测试或更正现有测试】
    * 【BUILD编译代码】-【影响构建系统或外部依赖项的更改:build.gradle、package.json、Podfile等】
    * 【CI持续集成】-【我们的CI配置文件和脚本的更改:Jenkinsfile等】
    * 【REVERT回退更改】-【代码回退提交更改】
    * 【CHORE其他提交】-【除以上所有类型之外的提交更改】

### 使用说明
在项目根目录的build.gradle文件中添加如下

    apply from: "${rootDir}/configs/dependencies/config.gradle"
    apply from: "${rootDir}/configs/dependencies/dependenciesx.gradle"
    apply from: "${rootDir}/configs/tools/gradle/git.gradle"

### 各组件使用

#### check_depx_versions.gradle

在项目的根目录下执行以下命令。

```
./gradlew dependencyUpdates
```

会在当前目录下生成 build/dependencyUpdates/report.txt 文件，内容如下所示：

```
The following dependencies have later release versions:
 - androidx.swiperefreshlayout:swiperefreshlayout [1.0.0 -> 1.1.0]
     https://developer.android.com/jetpack/androidx
 - com.squareup.okhttp3:logging-interceptor [3.9.0 -> 4.7.2]
     https://square.github.io/okhttp/
 - junit:junit [4.12 -> 4.13]
     http://junit.org
 - org.koin:koin-android [2.1.5 -> 2.1.6]
 - org.koin:koin-androidx-viewmodel [2.1.5 -> 2.1.6]
 - org.koin:koin-core [2.1.5 -> 2.1.6]

Gradle release-candidate updates:
 - Gradle: [6.1.1 -> 6.5.1]
```

会列出所有需要更新的依赖库的最新版本，并且 Gradle Versions Plugin 比 AndroidStudio 所支持的更加全面：

* 支持手动方式管理依赖库最新版本检查
* 支持 ext 的方式管理依赖库最新版本检查
* 支持 buildSrc 方式管理依赖库最新版本检查
* 支持 gradle-wrapper 最新版本检查
* 支持多模块的依赖库最新版本检查
* 支持多项目的依赖库最新版本检查

### 说明

#### 2.Android Jetpack
> Jetpack并不是一个框架或者组件，它是一套库、工具和指南的集合，可帮助开发者更轻松地编写优质应用。这些组件可帮助开发者遵循最佳做法、摆脱编写样板代码的工作并简化复杂任务，以便将精力集中放在所需的代码上。
  Android Jetpack中的很多组件并不都是新开发的，而是很早就有了，比如在Goole I/O 2017大会时推出了 Android Architecture Component（AAC），它包括了LifeCycle、LiveData、ViewModel、Room。在Goole I/O 2018大会上，
  用AndroidX替代了Android Support Library，并在Android Architecture Component的基础上发布了Android Jetpack，AndroidX也是属于Android Jetpack。

> 谷歌仍旧不断的完善Android Jetpack，截至到2019年8月已经有很多新加的组件并没有显示在上图中，比如CameraX等。Android Jetpack分类有4种，分别是Architecture、Foundationy、Behavior、UI，下面分别介绍下。


##### 2.1 Architecture（架构组件）

> Architecture指的是架构组件，帮助开发者设计稳健、可测试且易维护的应用。架构组件可以说是对应用开发帮助最大的组件，本系列也是围绕着架构组件进行讲解。

> DataBinding：以声明方式将可观察数据绑定到界面元素，通常和ViewModel配合使用。

> Lifecycle：用于管理Activity和Fragment的生命周期，可帮助开发者生成更易于维护的轻量级代码。

> LiveData: 在底层数据库更改时通知视图。它是一个可观察的数据持有者，与常规observable不同，LiveData是生命周期感知的.

> Navigation:处理应用内导航。

> Paging:可以帮助开发者一次加载和显示小块数据，按需加载部分数据可减少网络带宽和系统资源的使用。

> Room:友好、流畅的访问SQLite数据库。它在SQLite的基础上提供了一个抽象层，允许更强大的数据库访问。

> ViewModel: 以生命周期的方式管理界面相关的数据，通常和DataBinding配合使用，为开发者实现MVVM架构提供了强有力的支持。

> WorkManager: 管理Android的后台的作业，即使应用程序退出或设备重新启动也可以运行可延迟的异步任务。


##### 2.2 Foundation（基础组件）

> 基础组件提供横向功能，例如向后兼容性、测试、安全、Kotlin 语言支持，并包括多个多个平台开发的组件。

> Android KTX：优化了供Kotlin使用的Jetpack和Android平台API。帮助开发者以更简洁、更愉悦、更惯用的方式使用Kotlin进行Android开发。

> AppCompat：帮助较低版本的Android系统进行兼容。

> Auto: 开发Android Auto应用的组件，提供了适用于所有车辆的标准化界面和用户交互。

> 检测：从AndroidStudio中快速检测基于Kotlin或Java的代码。

> 多Dex处理：为具有多个Dex文件应用提供支持。

> 安全：安全的读写加密文件和共享偏好设置。

> 测试：用于单元和运行时界面测试的Android 测试框架。

> TV: 构建可让用户在大屏幕上体验沉浸式内容的应用。

> Wear OS:开发Wear应用的组件。


##### 2.3 Behavior（行为组件）

> 行为组件可帮助开发者的应用与标准Android服务（如通知、权限、分享）相集成。

> CameraX：帮助开发简化相机应用的开发工作。它提供一致且易于使用的界面，适用于大多数Android。 设备，并可向后兼容至Android 5.0（API 21）。

> DownloadManager：处理长时间运行的HTTP下载的系统服务。

> 媒体和播放：用于媒体播放和路由（包括Google Cast）的向后兼容API。

> 通知：提供向后兼容的通知API，支持Wear和Auto。

> 权限：用于检查和请求应用权限的兼容性API。

> 设置：创建交互式设置，建议使用AndroidX Preference Library库将用户可配置设置集成到应用中。

> 分享操作：可以更轻松地实现友好的用户分享操作。

> 切片：切片是一种UI模板，创建可在应用外部显示应用数据的灵活界面元素。


##### 2.4 UI（界面组件）
> Animation and Transition：该框架包含用于常见效果的内置动画，并允许开发者创建自定义动画和生命周期回调。

> Emoji Compatibility：即便用户没有更新Android系统也可以获取最新的表情符号。

> Fragment：组件化界面的基本单位。

> 布局：用XML中声明UI元素或者在代码中实例化UI元素。

> 调色板:从调色板中提取出有用的信息。

