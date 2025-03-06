package com.movie.service;

import com.movie.dto.PaymentDto;
import com.movie.dto.StripeResponse;
import com.stripe.Stripe;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value( "${stripe.secret.key}")
    private String secretKey;

    public StripeResponse checkoutProducts(PaymentDto paymentDto){
        Stripe.apiKey=secretKey;

        SessionCreateParams.LineItem.PriceData.ProductData productData = SessionCreateParams.LineItem.PriceData.ProductData.builder()
                .setName(paymentDto.getMovieTitle()).build();

        SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(paymentDto.getCurrency()==null?"USD":paymentDto.getCurrency())
                .setUnitAmount(paymentDto.getAmount())
                .build();
    }
}
