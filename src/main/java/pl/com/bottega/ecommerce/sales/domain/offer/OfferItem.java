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

    private Product product;

    private int quantity;

    private Money totalPrice;



    // product

    // discount
    private String discountCause;

    private BigDecimal discount;

    public OfferItem(Product product, int quantity, Money totalPrice, String discountCause, BigDecimal discount) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;

        this.discountCause = discountCause;
        this.discount = discount;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }

        this.totalPrice.setAmount(
                product.getPrice().getAmount().multiply(new BigDecimal(quantity)).subtract(discountValue)
        );
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferItem offerItem = (OfferItem) o;
        return quantity == offerItem.quantity
                && Objects.equals(product, offerItem.product)
                && Objects.equals(totalPrice, offerItem.totalPrice)
                && Objects.equals(discountCause, offerItem.discountCause)
                && Objects.equals(discount, offerItem.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, totalPrice, discountCause, discount);
    }

    /**
     *
     * @param otherItem
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem otherItem, double delta) {


        if (quantity != otherItem.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalPrice.getAmount().compareTo(otherItem.totalPrice.getAmount()) > 0) {
            max = totalPrice.getAmount();
            min = otherItem.totalPrice.getAmount();
        } else {
            max = otherItem.totalPrice.getAmount();
            min = totalPrice.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
