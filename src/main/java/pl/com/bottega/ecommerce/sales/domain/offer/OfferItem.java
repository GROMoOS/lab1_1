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

    private final int quantity;

    private final Money totalCost;
    // discount
    private final String discountCause;

    private final BigDecimal discount;

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

        this.totalCost = new Money(product.getPrice().getAmount().multiply(new BigDecimal(quantity)).subtract(discountValue),product.getPrice().getCurrency());
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
        if (o == null || getClass() != o.getClass()) return false;
        OfferItem offerItem = (OfferItem) o;
        return quantity == offerItem.quantity && product.equals(offerItem.product) && totalCost.equals(offerItem.totalCost) && Objects.equals(discountCause, offerItem.discountCause) && Objects.equals(discount, offerItem.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, totalCost, discountCause, discount);
    }
}
