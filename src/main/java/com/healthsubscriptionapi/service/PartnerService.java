package com.healthsubscriptionapi.service;

import java.util.List;

import com.healthsubscriptionapi.model.Partner;

public interface PartnerService {

    Partner save(Partner partner);

    Partner get(String id);

    List<Partner> getAll();
}
