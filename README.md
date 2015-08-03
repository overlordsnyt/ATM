# ATM <br/>ATM机模拟

学校项目实训课程做的一个小程序，虽然老师给了100分，但程序还未完成
<br/>本程序界面用以及后台用的Java，数据库用的MySQL



***
####功能
- 登录界面 （LoginUI）
  <br/>输入帐户密码登录ATM系统，输入“admin”帐户密码登录后台管理系统，退出按钮
- 主界面
  <br/>左右有登录账户、当前时间，带开户人姓名性别的欢迎语，功能按钮分别有：取款、存款、转账、查询余额、修改密码、退出
- 管理界面 （×表示未实现）
  <br/>功能：×流水明细、×变更账户信息、 ×存款类型转换、×开户、销户、返回登录界面


***
#### 包含文件

###### src\
- 默认根目录MainDo.java
  <br/>执行程序的主类主方法
  
- 信息相关（Bank）
  1. 显示时间线程
  2. 登录的账户信息
  
- 数据库连接（Database）
  <br/>连接数据库，执行SQL语句，有三种返回值：无返回值，返回更新条目数，返回查询结果表
  <br/>以及公用的关闭数据库连接方法
- 后台功能 （Server）
  * 登录功能 （Login.java）
    <br/>把获取的登录信息与数据库比对，存在信息则登录成功
  * 主界面功能 （Surface）
    1. 取款 （DrawMoney.java）
    2. 存款 （SaveMoney.java）
    3. 转账 （Transfer.java）
    5. 修改密码 （AlterPW.java）
  * 管理界面功能 （Interior）
    1. 销户 （Delete.java）
  
- 操作界面 （UI）
  * 通用接口 （Interface）
    1. 界面接口 （UI.java）
        只包含最基本的界面方法，颜色
    2. 带时间显示的界面 （DateUI.java）
        带一个时间显示标签，并有公用的改写时间标签的方法
    3. 通用界面 （General_UI.java）
        界面接口的一个实现类，并继承了带时间显示的界面，提供了一个标准界面的功能，包括关闭窗口监听器、已登录账户信息、窗口的基本设置等
    4. 通用小型界面 （SmallWindow_UI.java）
        规定了小型窗口的尺寸、返回主界面按钮以及未设置值的标签
    5. 通用管理界面 （AdminGeneral_UI.java）
        继承自带时间显示的界面，因无登录信息，故无跟随的账户信息
    6. 通用小型管理界面 （SmallAdmin_UI.java）
        继承自通用管理界面，规定了小型管理界面的尺寸，提供了返回管理界面的按钮，以及未设置具体值的标签及按钮
  * 登录界面 （LoginUI.java）
    欢迎语、账号密码输入框，登录、管理、退出等按钮
  * 主界面 （OutSide）
    1. 主界面 （MainInterface.java）
    2. 取款界面 （DrawUI.java）
    3. 存款界面 （SaveUI.java）
    4. 转账界面 （TransferUI.java）
    5. 查询余额界面 （InquiryUI.java）
    6. 修改密码界面 （AlterPasswordUI.java）
  * 管理界面 （InSide）
    1. 管理主界面 （AdministrationUI.java）
    2. 销户界面 （DeleteUI.java）
    3. -未完成- 开户界面 （EstablishUI.java）

###### 根目录
数据库文件 （atm.sql）
<br/>本ATM程序配套生成的数据库

