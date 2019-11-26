package aptech.fpt.springcart.controller;

import aptech.fpt.springcart.entity.Product;
import aptech.fpt.springcart.entity.ShoppingCart;
import aptech.fpt.springcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    private static final String SHOPPING_CART_ATTRIBUTE = "SHOPPING_CART";
    private static final Logger LOGGER = Logger.getLogger(CartController.class.getSimpleName());

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public String addCart(HttpSession session,
                          HttpServletResponse response,
                          @RequestParam(name = "productId") long id,
                          @RequestParam(name = "quantity", defaultValue = "1") int quantity) {
        Product product = productService.getById(id);
        if (product == null) {
            response.setStatus(404);
            return "NOT FOUND";
        }
        ShoppingCart cart = loadCart(session);
        LOGGER.log(Level.SEVERE, ("Cart null: " + (cart == null)));
        cart.addProduct(product, quantity);
        session.setAttribute(SHOPPING_CART_ATTRIBUTE, cart);
        return "Okie";
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/remove")
    @ResponseBody
    public String removeCart(HttpSession session,
                             @RequestParam(name = "productId") long id) {
        ShoppingCart cart = loadCart(session);
        cart.removeProduct(id);
        return "Okie";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public String getCart(HttpSession session, Model model) {
        ShoppingCart cart = loadCart(session);
        model.addAttribute("cart", cart);
        return "/cart/infor";
    }

    private ShoppingCart loadCart(HttpSession session) {
        ShoppingCart cart = null;
        try {
            cart = (ShoppingCart) session.getAttribute(SHOPPING_CART_ATTRIBUTE);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, String.format("Can't get cart from session: "), ex);
        }
        if (cart == null) {
            cart = new ShoppingCart();
        }
        return cart;
    }

}
