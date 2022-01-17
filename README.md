# demo  
  
請先把demo.mv.db檔案放至C:\ USER \ {USER} \ 路徑下  
專案clone下後 IDE執行DemoApplication 即可  
  
[登入](http://localhost:9100/login)  
[swagger-ui](http://localhost:9100/swagger-ui.html)  
[h2-console](http://localhost:9100/h2-console/)  
  
建議用Postman或swagger-ui操作(請用無痕)  
  
# 說明  
  
此Demo大概花了2天時間製作 (非常抱歉~ QQ)  
尚未做到unit tests 以及 Docker化..  
  
角色權限登入是用spring security做簡易權限管理 (權限部分是先寫在記憶體內)  
使用JPA方式處理存取DB  
  
package說明:  
  
com.example.demo.bussiness (商業邏輯相關)  
com.example.demo.config (設定檔案)  
com.example.demo.controller (Controller)  
com.example.demo.exception (錯誤處理)  
com.example.demo.model (bo, vo)  
com.example.demo.repository (repository)  
com.example.demo.security (spring security相關)  
com.example.demo.service (service)  


