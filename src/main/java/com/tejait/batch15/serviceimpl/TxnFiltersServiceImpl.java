package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.Transaction;
import com.tejait.batch15.repository.TxnFiltersRepository;
import com.tejait.batch15.service.TxnFiltersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TxnFiltersServiceImpl implements TxnFiltersService {

    private final TxnFiltersRepository repository;

    @Override
    public List<Transaction> filterTransactions(Integer appId,
                                                List<String> instruments,
                                                List<String> statuses) {

        if (instruments != null) {
            instruments = instruments.stream()
                    .map(i -> i.trim().toLowerCase())
                    .toList();
        }

        if (statuses != null) {
            statuses = statuses.stream()
                    .map(s -> s.trim().toUpperCase())
                    .toList();
        }

        if (instruments != null && !instruments.isEmpty() &&
                statuses != null && !statuses.isEmpty()) {

            return repository.findByAppIdAndInstrumentAndStatus(appId, instruments, statuses);

        } else if (instruments != null && !instruments.isEmpty()) {

            return repository.findByAppIdAndInstrument(appId, instruments);

        } else if (statuses != null && !statuses.isEmpty()) {

            return repository.findByAppIdAndTransactionStatusIn(appId, statuses);

        } else {

            return repository.findByAppId(appId);
        }
    }
}