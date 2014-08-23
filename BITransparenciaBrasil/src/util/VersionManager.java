package util;

import databeans.DataBean;

public class VersionManager {
   //static String _versionNumber = "Release Candidate 2.0";
    public static String getVersionNumber(){
        return DataBean.getParamValue("VERSION_NUMBER");//_versionNumber;
    }
    
    //static String _version = "Versão ";
    public static String getVersion(){
        return DataBean.getParamValue("VERSION");//_versionNumber;
    }
    
    //static String _sysName = "Plataforma de Gestão Empresarial - PGE";
    public static String getSysName(){
        return DataBean.getParamValue("SYS_NAME");//_sysName;
    }
    
    //static String _copyright = "Todos os Direitos Reservados - 2010";
    public static String getCopyright(){
        return DataBean.getParamValue("COPYRIGHT");//_copyright;
    }
    
    //static String _desenvolvedor = "Sinn Serviços e Soluções em Tecnologia Ltda.";
    public static String getDesenvolvedor(){
        return DataBean.getParamValue("OWNER");//_desenvolvedor;
    }
    
    //static String _cnpj = "11.808.150/0001-42";
    public static String getCNPJ(){
        return DataBean.getParamValue("CNPJ");//_cnpj;
    }
    
    public static String getUpdateURL(){
        return DataBean.getParamValue("UPDATE_URL");//_cnpj;
    }
    
    static Boolean _secure = false;
    public static Boolean isSecure(){
        return _secure;
    }
}
