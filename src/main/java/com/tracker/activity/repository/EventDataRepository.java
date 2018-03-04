package com.tracker.activity.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tracker.activity.constants.Constants;
import com.tracker.activity.entity.EventData;

public interface EventDataRepository extends JpaRepository<EventData, Long> {

	@Query(Constants.QUERY_DISTINCT_USERS_BY_CATEGORY_AND_DATE)
	List<String> findUniqueUserByEventTypeAndTs(@Param(value = "category") String category,
			@Param(value = "ts") Timestamp ts);

	@Query(Constants.QUERY_DISTINCT_USERS_IN_A_DAY)
	Long findUniqueUserInADay(@Param(value = "category") String category, @Param(value = "start") String start,
			@Param(value = "end") String end);

	@Query(Constants.QUERY_DISTINCT_USERS_VISIT)
	List<String> getUniqueVisiters(@Param(value = "category") String category, @Param(value = "start") String start,
			@Param(value = "end") String end, @Param(value = "frequency") Long frequency);

}
