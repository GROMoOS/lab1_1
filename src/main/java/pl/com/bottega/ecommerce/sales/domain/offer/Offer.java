package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Offer {

    private List<OfferItem> availableItems = new ArrayList<OfferItem>();

    private List<OfferItem> unavailableItems = new ArrayList<OfferItem>();

    public Offer(List<OfferItem> availabeItems, List<OfferItem> unavailableItems) {
        this.availableItems = availabeItems;
        this.unavailableItems = unavailableItems;
    }

    public List<OfferItem> getAvailableItems() {
        return availableItems;
    }

    public List<OfferItem> getUnavailableItems() {
        return unavailableItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(availableItems, offer.availableItems) && Objects.equals(unavailableItems, offer.unavailableItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableItems, unavailableItems);
    }
}
