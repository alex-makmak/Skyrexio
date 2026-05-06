package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TitleNaming {

    PRODUCTS("Products"),
    YOUR_CART("Your Cart"),
    CHECKOUT_YOUR_INFORMATION("Checkout: Your Information"),
    CHECKOUT_OVERVIEW("Checkout: Overview");

    private final String displayName;
}
