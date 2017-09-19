package com.kwler.legacy.api.metrics.mapper;

import com.kwler.legacy.api.metrics.model.FactFans;
import com.kwler.legacy.api.metrics.model.ArtistResults;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface FactFansMapper {

    @Select("SELECT * FROM fact_fans WHERE date_id = #{date} LIMIT #{limit}")
    List<FactFans> findByDate(@Param("date") Integer date, @Param("limit") Integer limit);

    @Select("SELECT * FROM fact_fans WHERE date_id = #{date} LIMIT #{limit}")
    List<Map<String, Object>> findByDateM(@Param("date") Integer date, @Param("limit") Integer limit);

    ArtistResults findArtists(@Param("limit") Integer limit);

    List<FactFans> findFansByDateAndArtistId(
            @Param("date") Integer date,
            @Param("artist") String artistId,
            @Param("page") Pageable page);
}
