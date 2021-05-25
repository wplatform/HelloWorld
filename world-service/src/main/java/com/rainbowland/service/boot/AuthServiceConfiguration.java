package com.rainbowland.service.boot;

import com.rainbowland.service.AbstractServiceConfiguration;
import com.rainbowland.service.R2dbcProperties;
import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.auth.AuthServiceImpl;
import com.rainbowland.service.auth.domain.*;
import com.rainbowland.service.realm.LocalRealmManager;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

@Configurable
public class AuthServiceConfiguration extends AbstractServiceConfiguration {


    @Bean
    @ConfigurationProperties("datasource.auth")
    public R2dbcProperties authR2dbcProperties() {
        return new R2dbcProperties();
    }

    @Bean
    public ConnectionFactory authConnectionFactory(@Qualifier("authR2dbcProperties") R2dbcProperties properties) {
        return super.connectionFactory(properties);
    }

    @Bean
    public DatabaseClient authDatabaseClient(@Qualifier("authConnectionFactory") ConnectionFactory connectionFactory) {
        return super.databaseClient(connectionFactory);
    }
    @Bean
    public R2dbcEntityTemplate authR2dbcEntityTemplate(@Qualifier("authDatabaseClient") DatabaseClient databaseClient) {
        return super.r2dbcEntityTemplate(databaseClient);
    }

    @Bean
    public AuthService authService(@Qualifier("authR2dbcEntityTemplate") R2dbcEntityTemplate template) {
        return new AuthServiceImpl(template);
    }

    @Override
    protected List<Converter<?, ?>> getCustomConverters() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new Account.RowMapper());
        converterList.add(new Account.ParamMapper());
        converterList.add(new AccountAccess.RowMapper());
        converterList.add(new AccountAccess.ParamMapper());
        converterList.add(new AccountBanned.RowMapper());
        converterList.add(new AccountBanned.ParamMapper());
        converterList.add(new AccountLastPlayedCharacter.RowMapper());
        converterList.add(new AccountLastPlayedCharacter.ParamMapper());
        converterList.add(new AccountMuted.RowMapper());
        converterList.add(new AccountMuted.ParamMapper());
        converterList.add(new Autobroadcast.RowMapper());
        converterList.add(new Autobroadcast.ParamMapper());
        converterList.add(new BattlePetSlot.RowMapper());
        converterList.add(new BattlePetSlot.ParamMapper());
        converterList.add(new BattlePet.RowMapper());
        converterList.add(new BattlePet.ParamMapper());
        converterList.add(new BattlenetAccountBan.RowMapper());
        converterList.add(new BattlenetAccountBan.ParamMapper());
        converterList.add(new BattlenetAccountHeirloom.RowMapper());
        converterList.add(new BattlenetAccountHeirloom.ParamMapper());
        converterList.add(new BattlenetAccountMount.RowMapper());
        converterList.add(new BattlenetAccountMount.ParamMapper());
        converterList.add(new BattlenetAccountToy.RowMapper());
        converterList.add(new BattlenetAccountToy.ParamMapper());
        converterList.add(new BattlenetAccount.RowMapper());
        converterList.add(new BattlenetAccount.ParamMapper());
        converterList.add(new BattlenetItemAppearance.RowMapper());
        converterList.add(new BattlenetItemAppearance.ParamMapper());
        converterList.add(new BattlenetItemFavoriteAppearance.RowMapper());
        converterList.add(new BattlenetItemFavoriteAppearance.ParamMapper());
        converterList.add(new BuildInfo.RowMapper());
        converterList.add(new BuildInfo.ParamMapper());
        converterList.add(new IpBanned.RowMapper());
        converterList.add(new IpBanned.ParamMapper());
        converterList.add(new Log.RowMapper());
        converterList.add(new Log.ParamMapper());
        converterList.add(new LogsIpAction.RowMapper());
        converterList.add(new LogsIpAction.ParamMapper());
        converterList.add(new RbacAccountPermission.RowMapper());
        converterList.add(new RbacAccountPermission.ParamMapper());
        converterList.add(new RbacDefaultPermission.RowMapper());
        converterList.add(new RbacDefaultPermission.ParamMapper());
        converterList.add(new RbacLinkedPermission.RowMapper());
        converterList.add(new RbacLinkedPermission.ParamMapper());
        converterList.add(new RbacPermission.RowMapper());
        converterList.add(new RbacPermission.ParamMapper());
        converterList.add(new Realmcharacter.RowMapper());
        converterList.add(new Realmcharacter.ParamMapper());
        converterList.add(new Realmlist.RowMapper());
        converterList.add(new Realmlist.ParamMapper());
        converterList.add(new Update.RowMapper());
        converterList.add(new Update.ParamMapper());
        converterList.add(new UpdatesInclude.RowMapper());
        converterList.add(new UpdatesInclude.ParamMapper());
        converterList.add(new Uptime.RowMapper());
        converterList.add(new Uptime.ParamMapper());
        return converterList;
    }


    @Bean(initMethod = "init")
    public LocalRealmManager realmManager(AuthService service) {
        LocalRealmManager realmManager = new LocalRealmManager(service);
        return realmManager;
    }

}
