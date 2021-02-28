package com.restudy.selectshop.controller;

import com.restudy.selectshop.domain.ItemDto;
import com.restudy.selectshop.util.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {
    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getSearch (@RequestParam String query){
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItem(resultString);
    }
}
