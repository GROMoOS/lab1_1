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
import java.util.Objects;

public class OfferItem {
    // product
    private final Product product;
    private final Money totalCost;

    // discount
    private final String discountCause;
    private final BigDecimal discount;
    private final int quantity;

    public OfferItem(Product product, int quantity, Money totalCost) {
        this(product, totalCost, quantity, null, null);
    }

    public OfferItem(Product product, Money totalCost, int quantity, BigDecimal discount, String discountCause) {
        this.product = product;
        this.totalCost = totalCost;
        this.quantity = quantity;
        this.discount = discount;
        this.discountCause = discountCause;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

        this.totalCost.setAmount(product.getPrice().getAmount().multiply(new BigDecimal(quantity)).subtract(discountValue));
    }

    public BigDecimal getTotalCost() {
        return totalCost.getAmount();
    }

    public String getTotalCostCurrency() {
        return totalCost.getCurrency();
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount == null ? 0 : discount.hashCode());
        result = prime * result + product.hashCode();
        result = prime * result + quantity;
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        return Objects.equals(discount, other.discount) &&
                Objects.equals(totalCost, other.totalCost) &&
                product.equals(other.product) &&
                quantity == other.quantity;
    }

    /**
     *
     * @param other another OfferItem to compare with
     * @param delta acceptable percentage difference
     * @return true if price difference is good enough
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (!product.equals(other.product))
            return false;

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max = totalCost.getAmount().max(other.totalCost.getAmount());
        BigDecimal min = totalCost.getAmount().min(other.totalCost.getAmount());
        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

    public String getProductId() {
        return product.getId();
    }
}
