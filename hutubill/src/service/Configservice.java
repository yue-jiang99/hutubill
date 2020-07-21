package service;


import dao.ConfigDAO;
import entity.Config;

public class Configservice {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    private static ConfigDAO dao = new ConfigDAO();
    static {init();}

    private static void init() {
        init(budget,default_budget);
        init(mysqlPath,"");
    }

    /**
     * 根据key值和value值配置初始信息
     * @param key
     * @param value
     */
    private static void init(String key,String value){
        Config config = dao.getByKey(key);
        if (null == config){
            Config config1 = new Config();
            config1.setKey(key);
            config1.setValue(value);
            dao.add(config1);
        }
    }

    /**
     * 根据key值获得相应的配置信息
     * @param key
     * @return
     */
    public String getValueByKey(String key){
        Config config = dao.getByKey(key);
        return config.getValue();
    }

    /**
     * 更新一个配置信息
     * @param key
     * @param value
     */
    public void update(String key,String value){
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }


    /**
     * 获取预算
     * @return
     */
    public int getIntBudget(){
        return Integer.parseInt(getValueByKey(Configservice.budget));
    }
}
