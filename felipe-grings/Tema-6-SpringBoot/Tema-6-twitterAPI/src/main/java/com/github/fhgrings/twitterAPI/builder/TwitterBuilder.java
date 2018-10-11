package com.github.fhgrings.twitterAPI.builder;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterBuilder {

    @Bean
    public twitter4j.Twitter build() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAccessTokenSecret("k1cVIhjEvu47d6bPfMCs8STnzSzxyDPtwReGBIokIbdlU")
                .setOAuthAccessToken("205951663-1SCO5YjYlp88S1pBLf22KL6KLOmtDb75cKSIAjvx")
                .setOAuthConsumerKey("WESmGnu3CWPK6xQSEd89Pa5tG")
                .setOAuthConsumerSecret("MtidOg1yiHDE0aivAfRt5NiJ1Uegbq5AxCgqcojPqSga82mMXI");

        return new TwitterFactory(cb.build()).getInstance();
    }
}
