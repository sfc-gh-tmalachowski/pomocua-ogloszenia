package pl.gov.coi.pomocua.ads.accomodations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.gov.coi.pomocua.ads.BaseOffer;
import pl.gov.coi.pomocua.ads.UserId;

import java.util.Optional;

public interface AccommodationsRepository extends PagingAndSortingRepository<AccommodationOffer, Long> {

    Optional<AccommodationOffer> findByIdAndUserId(Long id, UserId userId);

    Page<AccommodationOffer> findAllByLocation_RegionIgnoreCaseAndLocation_CityIgnoreCaseAndGuestsIsGreaterThanEqualAndStatus(
            String region,
            String city,
            int guests,
            BaseOffer.Status status,
            Pageable pageable
    );

    Page<AccommodationOffer> findAllByGuestsIsGreaterThanEqualAndStatus(
            int guests,
            BaseOffer.Status status,
            Pageable pageable
    );
}
