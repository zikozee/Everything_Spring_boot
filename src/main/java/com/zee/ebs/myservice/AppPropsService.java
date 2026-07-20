package com.zee.ebs.myservice;


import com.zee.ebs.configprops.AppProperties;
import com.zee.ebs.configprops.AppRecordProps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class AppPropsService implements CommandLineRunner {
    private final AppProperties appProperties;
    private final AppRecordProps appRecordProps;

    @Override
    public void run(String... args) throws Exception {

        log.info("AppProperties:->  name: {}, ip: {}, port: {}, securityEnabled: {}, securityToken: {}, securityRoles:{}",
                appProperties.getName(), appProperties.getIp(), appProperties.getPort(), appProperties.getSecurity().isEnabled(),
                appProperties.getSecurity().getToken(), appProperties.getSecurity().getRoles()
        );

        log.info("RecordProperties:->  name: {}, ip: {}, port: {}, securityEnabled: {}, securityToken: {}, securityRoles:{}",
                appRecordProps.name(), appRecordProps.ip(), appRecordProps.port(), appRecordProps.security().enabled(),
                appRecordProps.security().token(), appRecordProps.security().roles()
        );

    }
}
