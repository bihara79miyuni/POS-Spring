package com.pos.Spring.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.Spring.Security.UserDetailsServiceImpl;
import com.pos.Spring.Service.ItemService;
import com.pos.Spring.Service.StockService;
import com.pos.Spring.Service.TransactionService;
import com.pos.Spring.Service.UserService;
import com.pos.Spring.dto.TransactionReqDto;
import com.pos.Spring.dto.UserReqDto;
import com.pos.Spring.entity.Item;
import com.pos.Spring.entity.Stock;
import com.pos.Spring.entity.Transaction;
import com.pos.Spring.entity.User;
import com.pos.Spring.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@CrossOrigin(origins="*")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockService stockService;

    @Autowired
    private UserService userService;

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.status(200).body(transactions);
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction>createTransaction(@RequestBody TransactionReqDto transactionReqDto,HttpServletRequest request){
        
        Transaction transaction = new Transaction();

        transaction.setTotalAmount(0.0);

        List<Long> itemIds = transactionReqDto.getItemIds();

        List<Item> itemTransactions = new ArrayList<>();

        // String jwt = extractJwtFromRequest(request);
        //     if (jwt == null) {
        //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        // }

        // String username = getUsernameFromJwt(jwt,"${app.secret}");

        // if (transactionReqDto.getItemIds() == null || transactionReqDto.getItemIds().isEmpty()) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        // }

        itemIds.forEach(itemId ->{
            Item item = itemService.getItemById(itemId);
            Stock stock = stockService.getStockById(itemId);

            if(item!=null){
                itemTransactions.add(item);
                transaction.setTotalAmount(transaction.getTotalAmount()+item.getPrice());
                stock.setQuantity(stock.getQuantity()-1);
            }else{
                System.out.println("id null");            
            }
        });

        transaction.setItems(itemTransactions);
        //transaction.setUser(userService.getUserByUsername(username));
    

        transactionService.createTransaction(transaction);

        return ResponseEntity.status(200).body(transaction);

    }

//     private String extractJwtFromRequest(HttpServletRequest request) {
//         String bearerToken = request.getHeader("Authorization");
//         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//             return bearerToken.substring(7); // Remove "Bearer " prefix
//         }
//         return null;
//     }

//     private String getUsernameFromJwt(String jwt, String secretKey) {
//         byte[] keyBytes = Base64.getDecoder().decode(secretKey);
//         SecretKey key = Keys.hmacShaKeyFor(keyBytes);

//     Claims claims = Jwts.parserBuilder()
//             .setSigningKey(key)
//             .build()
//             .parseClaimsJws(jwt)
//             .getBody();
//     return claims.getSubject(); // Username is typically stored in the "sub" claim
// }

}

