package com.devlogger.post.repository;

import com.devlogger.post.model.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author swop4a
 * @since 14/05/2018 14:30
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'publisher.handle': { $in: ?0 } }")
	List<Post> findAllByPublisherHandleInAndOrderByPublicationDateDesc(List<String> handles);

	@Query(value = "{ 'publisher.handle' : ?0 }", fields = "{ 'publisher.handle': 0 }")
	List<Post> findAllByPublisherHandleAndOrderByPublicationDateDesc(String handle);

	List<Post> findAllByOrderByPublicationDateDesc();
}
