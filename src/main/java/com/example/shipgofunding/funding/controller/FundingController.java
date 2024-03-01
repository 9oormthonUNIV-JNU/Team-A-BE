package com.example.shipgofunding.funding.controller;

import com.example.shipgofunding.config.utils.ApiResponseBuilder;
import com.example.shipgofunding.funding.response.FundingResponse.PopularFundingMainPageResponseDTO;
import com.example.shipgofunding.funding.response.FundingResponse.BannerResponseDTO;
import com.example.shipgofunding.funding.response.FundingResponse.UrgentFundingResponseDTO;
import com.example.shipgofunding.funding.service.FundingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Product", description = "상품 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FundingController {

    private final FundingService fundingService;

    @Operation(summary = "메인 배너 조회", description = "메인 페이지에 표시될 배너 데이터를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공적으로 배너 데이터 조회",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BannerResponseDTO.class)))
    @GetMapping("/banners/main")
    public ResponseEntity<?> getMainBanners() {
        //TO-DO : 메인 배너 데이터를 조회하는 로직 구현하기
        List<BannerResponseDTO> banners = fundingService.getMainBanners();

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(banners));
    }

    @Operation(summary = "72 시간 이내 상품 3개 조회", description = "메인 페이지에 표시될 마감임박 상품 데이터를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공적으로 마감임박 상품 데이터 조회",
    content = @Content(mediaType = "application/json",
    schema = @Schema(implementation = UrgentFundingResponseDTO.class)))
    @GetMapping("/fundings/urgent")
    public ResponseEntity<?> getUrgentFundings() {
        //TO-DO : 긴급 펀딩 데이터를 조회하는 로직 구현하기 ( 3개의 랜덤 마감 임박 데이터를 뽑아내야함 )
        List<UrgentFundingResponseDTO> urgentFundingImages = fundingService.getUrgentFundingImages();

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(urgentFundingImages));
    }

    @Operation(summary = "인기 상품 조회", description = "메인 페이지에 표시될 인기 상품 데이터를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공적으로 인기 상품 데이터 조회",
    content = @Content(mediaType = "application/json",
    schema = @Schema(implementation = PopularFundingMainPageResponseDTO.class)))
    @GetMapping(value = "/fundings/popular", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> getPopularMainPageFundings() {
        //TO-DO : 인기 펀딩 데이터를 조회하는 로직 구현하기 ( 인기순으로 정렬된 6개의 데이터를 뽑아내야 함 )
        List<PopularFundingMainPageResponseDTO> popularFundings = fundingService.getPopularMainPageFundings();

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(popularFundings));
    }

}
