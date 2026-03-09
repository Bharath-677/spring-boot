package com.tejait.batch15.service;

import com.tejait.batch15.model.AssuranceDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AssuranceDetailsService {
    void saveFromJson(int appId, MultipartFile file);

    // ========= SAVE CHANGES =========
    @Transactional
    void saveAll(int appId, List<AssuranceDetails> list);

    List<AssuranceDetails> getAllByAppId(int appId);

    void saveAll(Integer appId, List<AssuranceDetails> list);
}
