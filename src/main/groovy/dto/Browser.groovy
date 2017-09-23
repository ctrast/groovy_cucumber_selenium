package dto

class Browser {

    private String name
    private String version
    private String platform
    private String url

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getVersion() {
        return version
    }

    void setVersion(String version) {
        this.version = version
    }

    String getPlatform() {
        return platform
    }

    void setPlatform(String platform) {
        this.platform = platform
    }

    String getUrl() {
        return url
    }

    void setUrl(String url) {
        this.url = url
    }


}