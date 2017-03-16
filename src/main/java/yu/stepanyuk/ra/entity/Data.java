package yu.stepanyuk.ra.entity;

import javax.persistence.*;

@Entity
@Table(name = "full_features")
public class Data implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_data", nullable = false)
    private Long id;

    @Basic
    @Column(length = 64)
    private String rendering_engine;

    @Basic
    @Column(length = 64)
    private String browser;

    @Basic
    @Column(length = 64)
    private String platform;

    @Basic
    @Column(length = 8)
    private String engine_version;

    @Basic
    @Column(length = 4)
    private String css_grade;

    public Data() {
    }

    public Data(Long id, String rendering_engine, String browser, String platform, String engine_version, String css_grade) {
        this.id = id;
        this.rendering_engine = rendering_engine;
        this.browser = browser;
        this.platform = platform;
        this.engine_version = engine_version;
        this.css_grade = css_grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRendering_engine() {
        return rendering_engine;
    }

    public void setRendering_engine(String rendering_engine) {
        this.rendering_engine = rendering_engine;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getEngine_version() {
        return engine_version;
    }

    public void setEngine_version(String engine_version) {
        this.engine_version = engine_version;
    }

    public String getCss_grade() {
        return css_grade;
    }

    public void setCss_grade(String css_grade) {
        this.css_grade = css_grade;
    }
}
