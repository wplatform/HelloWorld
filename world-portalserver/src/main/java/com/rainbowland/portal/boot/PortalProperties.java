package com.rainbowland.portal.boot;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Setter
@Getter
public class PortalProperties {

    private String portalUrl;

    private Duration loginTicketDuration = Duration.ofMillis(3600);


}
