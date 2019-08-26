# DViewSummary
[Android 5.0、6.0新增控件学习整理](https://www.jianshu.com/p/e627c31961c3)  

2019/8/26修改，已将support包替换成andriodx。
   
### 一、Android 5.0、6.0新增控件学习整理

**新增控件如下**

1、CardView、RecyclerView、SwipeRefreshLayout、TabLayout、NavigationView、Snackbar、FloatingActionButton

2、TextInputLayout、TextInputEditText

3、CoordinatorLayout、AppBarLayout、CollapsingToolbarLayout、ToolBar

在整理学习时可以简单地把这些归为其他，与EditText相关，与和滚动效果相关，实际上并没有这样的分法，只是为了一眼看出哪些与哪些有关联。

控件|简述
--|--
CardView | 5.0推出的带圆角和阴影的布局，继承自FrameLayout，在cardview-v7中。阴影效果不佳，不常用。
RecyclerView | 是用来代替ListView和GridView，在recyclerview-v7中。常用。
SwipeRefreshLayout | 下拉刷新控件，没有加载更多功能，在v4包中。
TabLayout | 选项卡，是一个用于放置水平Tab的布局，常见和viewpager、fragment搭配。常用，几乎每个app首页都能看到。
NavigationView | 导航视图，用于DrawerLayout抽屉布局中，侧拉拉出的那部分页面就是NavigationView，它提供一个规范，包含一个header和menu布局，在desgin包中。
Snackbar | 提示信息的展示，用来代替Toast，从底部滑出，主要区别是Snackbar可以滑动退出，也可以处理用户交互（点击）事件，在design包中。很少见到这效果。
FloatingActionButton |  一个悬浮的按钮，简称FAB，比较常见的是在要滚动的页面，浮现一个点击置顶的FAB，在design包中。

**EditText相关**

TextInputLayout继承自LinearLayout，TextInputEditText继承自AppCompatEditText，都在design包中。

控件|简述
--|--
TextInputLayout | 主要是作为EditText的容器，它能做的功能有Hint字符串自动移到左上角，设置最大字符数及错误提示，设置错误提示文字，设置密码可见开关等。
TextInputEditText |  用来处理输入法在'extract'模式的时候，hint无法显示问题。用TextInputLayout时，如果用EditText虽然不至于报错，但会打印info建议我们替换成TextInputEditText。

**和滚动效果相关**

控件|简述
--|--
CoordinatorLayout | CoordinatorLayout是一个布局管理器，主要用通过Behavior协调子View交互行为。
AppBarLayout | 是一种支持响应滚动手势的app bar布局，例如可以做折叠导航栏。
CollapsingToolbarLayout | 是专门用来实现子布局内不同元素响应滚动细节的布局，作为AppBarLayout的直接子布局。
ToolBar  | 工具栏（标题栏），代替ActionBar，在appcompat-v7包中。

<img src="https://github.com/Dengszzzzz/DViewSummary/blob/master/app/src/main/assets/5.0%E5%92%8C6.0%E6%96%B0%E5%A2%9E%E6%8E%A7%E4%BB%B6.jpg" width="280" />    <img src="https://github.com/Dengszzzzz/DViewSummary/blob/master/app/src/main/assets/1_4.jpg" width="280" />

### 二、Android 5.0、6.0新增与View相关的功能
1）View的高度和阴影
   
   Z属性由elevation 和 translationZ组成。elevation表示view的高度，高度越大，阴影越大。transtionZ属性表示view在Z方向移动的距离，一般用于属性动画中。
   
2）View的轮廓与裁剪   
   
   View的阴影是由轮廓决定的，对轮廓的判定可以设置android:outlineProvider的值，裁剪是用View.setClipToOutline(true);
   
3）Palette(调色板)
   
   Palette使用，从一张图片中提取出关键的颜色，可以把该颜色值设置到别的控件上面。
    
4）水波纹动画，自定义水波纹动画以及状态选择器动画
   
   5.0以上，点击效果默认自带水波纹效果，可以自定义水波纹效果，状态选择器动画可以设置带属性动画的or帧动画的。
   
5）如何动态替换theme？
  
   在styles.xml设置多套布局，再在Activity的onCreateView()前调用setTheme。
 
 <img src="https://github.com/Dengszzzzz/DViewSummary/blob/master/app/src/main/assets/2_1.jpg" width="280" />
 
 ### 三、Android 7.0、8.0、9.0整理
 
 **Android 7.0（N）**
 
1.多窗口支持（分屏模式）

2.桌面长按图标出现快捷方式

**Android 8.0（O）**

1.画中画模式（PIP，其实就像是分屏模式的优化版）

2.自定义字体，可下载字体（AS 3.x以上可以找到，但没有中文字体可下载）。

3.自动缩放文本视图（Autosizing TextView）

**Android 9.0(P)**

1.刘海屏适配。

2.ImageDecoder 和 AnimagedImageDrawable。

 

