rmdir /s /q www
rmdir /s /q "E:\DilipMyInstalls\apache-tomcat-5.5.17\webapps\dimdim\html\layout\"
@java -Xms512M -Xmx512M -cp "%~dp0\src;..\..\ThirdPartyPackages\GWT15\gwt-user.jar;gwt-servlet.jar;..\..\ThirdPartyPackages\GWT15\gwt2swf.jar;..\..\ThirdPartyPackages\GWT15\gwt-dev-windows.jar;..\..\ThirdPartyPackages\GWT15\gwt-widgets-0.2.0.jar;..\..\ThirdPartyPackages\GWT15\gwttk-SNAPSHOT.jar;../../ThirdPartyPackages/UICommon/dimdim_ui_common.jar" com.google.gwt.dev.GWTCompiler -out "%~dp0\www" %* com.dimdim.conference.ui.layout.NewLayout

mkdir "E:\DilipMyInstalls\apache-tomcat-5.5.17\webapps\dimdim\html\layout"
xcopy /E /R /Y www\com.dimdim.conference.ui.layout.NewLayout\* "E:\DilipMyInstalls\apache-tomcat-5.5.17\webapps\dimdim\html\layout"
