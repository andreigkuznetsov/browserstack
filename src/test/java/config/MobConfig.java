package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})
public interface MobConfig extends Config {

    String username();

    String password();

    String appUrl();

    String remoteUrl();

    String videoUrl();

}
