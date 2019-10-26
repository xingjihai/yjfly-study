package com.thirdparty.weixin.bean;

/**个性化菜单字段(可以设置多套菜单分给不同的用户群体)
 * @author wyj
 */
public class MenuConditionalField {
    /**
     * tag_id   否   用户标签的id，可通过用户标签管理接口获取
    sex 否   性别：男（1）女（2），不填则不做匹配
    client_platform_type    否   客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
    country 否   国家信息，是用户在微信中设置的地区，具体请参考地区信息表
    province    否   省份信息，是用户在微信中设置的地区，具体请参考地区信息表
    city    否   城市信息，是用户在微信中设置的地区，具体请参考地区信息表
    language    否   语言信息，是用户在微信中设置的语言，具体请参考语言表：1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK "zh_HK" 4、英文 "en" 5、印尼 "id" 6、马来 "ms" 7、西班牙 "es" 8、韩国 "ko" 9、意大利 "it" 10、日本 "ja" 11、波兰 "pl" 12、葡萄牙 "pt" 13、俄国 "ru" 14、泰文 "th" 15、越南 "vi" 16、阿拉伯语 "ar" 17、北印度 "hi" 18、希伯来 "he" 19、土耳其 "tr" 20、德语 "de" 21、法语 "fr"
     */
    private String tag_id;
    private String sex;
    private String client_platform_type;
    private String country;
    private String province;
    private String city;
    private String language;
    public String getTag_id() {
        return tag_id;
    }
    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getClient_platform_type() {
        return client_platform_type;
    }
    public void setClient_platform_type(String client_platform_type) {
        this.client_platform_type = client_platform_type;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    
}
