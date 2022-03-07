/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    // product
    private Product product;

    private int quantity;

    private Money totalCost;

    // discount
    private String discountCause;

    private BigDecimal discount;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null, null);
    }

    public OfferItem(Product product, int quantity, BigDecimal discount, String discountCause) {
        this.product = product;

        this.quantity = quantity;
        this.discount = discount;
        this.discountCause = discountCause;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

        this.totalCost = new Money(product.getPrice().getAmount().multiply(new BigDecimal(quantity)).subtract(discountValue), product.getPrice().getCurrency());
    }

    public Product getProduct() {
        return product;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferItem)) return false;
        OfferItem offerItem = (OfferItem) o;
        return quantity == offerItem.quantity && product.equals(offerItem.product) && totalCost.equals(offerItem.totalCost) && discountCause.equals(offerItem.discountCause) && Objects.equals(discount, offerItem.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, totalCost, discountCause, discount);
    }

    /**
     *
     * @param other
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (product.getName() == null) {
            if (other.getProduct().getName() != null) {
                return false;
            }
        } else if (!product.getName().equals(other.getProduct().getName())) {
            return false;
        }
        if (product.getPrice() == null) {
            if (other.getProduct().getPrice() != null) {
                return false;
            }
        } else if (!product.getPrice().equals(other.getProduct().getPrice())) {
            return false;
        }
        if (product.getId() == null) {
            if (other.getProduct().getId() != null) {
                return false;
            }
        } else if (!product.getId().equals(other.getProduct().getId())) {
            return false;
        }
        if (!Objects.equals(product.getType(), other.getProduct().getType())) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getAmount().compareTo(other.totalCost.getAmount()) > 0) {
            max = totalCost.getAmount();
            min = other.totalCost.getAmount();
        } else {
            max = other.totalCost.getAmount();
            min = totalCost.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
