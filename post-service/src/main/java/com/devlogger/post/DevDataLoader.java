package com.devlogger.post;

import com.devlogger.account.model.Account;
import com.devlogger.post.client.AccountServiceClient;
import com.devlogger.post.model.Comment;
import com.devlogger.post.model.Like;
import com.devlogger.post.model.Post;
import com.devlogger.post.model.PostType;
import com.devlogger.post.repository.PostRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author swop4a
 * @since 26/05/2018 13:52
 */
@Component
@Profile("dev")
public class DevDataLoader {

	@Bean
	public CommandLineRunner commandLineRunner(PostRepository repository, AccountServiceClient client) {
		return args -> {
			repository.deleteAll();

			Account jProgrammer = client.getAccountByName("JProgrammer");

			Post java9 = Post.builder()
				.id("java9")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://pbs.twimg.com/media/DBkd2vsUQAAi478.jpg")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(jProgrammer)
				.tags(Arrays.asList("java", "java 9", "features"))
				.title("Что нового в Java 9")
				.type(PostType.PUBLICATION)
				.comments(Collections
					.singletonList(Comment.builder().author("JProgrammer").content("My post!").build()))
				.build();
			repository.save(java9);

			Post collections = Post.builder()
				.id("collections")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image(
					"http://2.bp.blogspot.com/--TKVKPvDDDo/VaOStW0hp2I/AAAAAAAAAYY/3FV0T7ghvMk/s1600/Java%2B-%2BCollection%2BFramework%2B-%2BHierarchy.jpg")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(jProgrammer)
				.tags(Arrays.asList("java", "collections", "java core"))
				.title("Справочник по Java Collections")
				.type(PostType.PUBLICATION)
				.build();
			repository.save(collections);

			Account pProgrammer = client.getAccountByName("PProgrammer");

			Post djangoOrm = Post.builder()
				.id("django_orm")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://s3.amazonaws.com/fullstackfeed/images/django-1.jpg")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(pProgrammer)
				.tags(Arrays.asList("python", "django", "databases", "orm"))
				.title("Django ORM")
				.type(PostType.PUBLICATION)
				.build();
			repository.save(djangoOrm);

			Post pythonGui = Post.builder()
				.id("python_gui")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://cdn.tproger.ru/wp-content/uploads/2018/03/pyqt-1.jpg")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now().minusWeeks(1))
				.publisher(pProgrammer)
				.tags(Arrays.asList("python", "gui", "qt", "pythonQt", "qtDesigner"))
				.title("Python GUI: создаём простое приложение с PyQt и Qt Designer")
				.likes(Arrays.asList(Like.builder().handle("JProgrammer").time(LocalDateTime.now()).build()))
				.type(PostType.PUBLICATION)
				.build();
			repository.save(pythonGui);

			Account postMaker = client.getAccountByName("PostMaker");

			Post multithreading = Post.builder()
				.id("multithreading")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://www.tutorialspoint.com/java/images/Thread_Life_Cycle.jpg")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now().minusWeeks(2))
				.publisher(postMaker)
				.tags(Arrays.asList("java", "multithreading", "java memory model", "jmm"))
				.title("Multithreading in practice")
				.type(PostType.PUBLICATION)
				.likes(Arrays.asList(Like.builder().handle("JProgrammer").time(LocalDateTime.now()).build()))
				.comments(Collections
					.singletonList(Comment.builder().author("JProgrammer").content("I know this!").build()))
				.build();
			repository.save(multithreading);

			Post springInAction = Post.builder()
				.id("spring_in_action")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://tproger.ru/wp-content/uploads/2018/03/spring-logo.jpg")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(postMaker)
				.tags(Arrays.asList("java", "spring", "spring framework", "IoC", "DI"))
				.title("Spring в действии")
				.type(PostType.PUBLICATION)
				.likes(Arrays.asList(Like.builder().handle("JProgrammer").time(LocalDateTime.now()).build()))
				.comments(Collections
					.singletonList(Comment.builder().author("JProgrammer").content("I know this!").build()))
				.build();
			repository.save(springInAction);

			Post jvm = Post.builder()
				.id("jvm")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://i.ytimg.com/vi/G1ubVOl9IBw/maxresdefault.jpg")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(postMaker)
				.tags(Arrays.asList("java", "jvm"))
				.title("How JVM works?")
				.type(PostType.PUBLICATION)
				.likes(Arrays.asList(Like.builder().handle("JProgrammer").time(LocalDateTime.now()).build()))
				.build();
			repository.save(jvm);

			Post python3 = Post.builder()
				.id("python3")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://www.python.org/static/community_logos/python-logo-master-v3-TM.png")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(postMaker)
				.tags(Arrays.asList("python", "python3"))
				.title("Обзор нововведений в Python 3")
				.type(PostType.PUBLICATION)
				.comments(Collections
					.singletonList(Comment.builder().author("PProgrammer").content("I know this!").build()))
				.likes(Arrays.asList(Like.builder().handle("PProgrammer").time(LocalDateTime.now()).build()))
				.build();
			repository.save(python3);

			Post bestIdesForPython = Post.builder()
				.id("best_python_ide")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://www.jetbrains.com/pycharm-edu/learners/img/intro.png")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(postMaker)
				.tags(Arrays.asList("python", "IDE", "PyCharm"))
				.title("Лучшие IDE для Python")
				.type(PostType.PUBLICATION)
				.likes(Arrays.asList(Like.builder().handle("PProgrammer").time(LocalDateTime.now()).build()))
				.build();
			repository.save(bestIdesForPython);

			Post mongoForBeginners = Post.builder()
				.id("mongodb_for_beginners")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "\n\n"
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "\n\n"
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "\n\n"
						+ "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/USMl2GNg2r0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
						+ "\n\n"
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "\n\n"
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "\n\n"
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "\n\n"
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "\n\n"
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "\n\n"
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "\n\n"
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image(
					"https://webassets.mongodb.com/_com_assets/cms/MongoDB-Logo-5c3a7405a85675366beb3a5ec4c032348c390b3f142f5e6dddf1d78e2df5cb5c.png")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(postMaker)
				.tags(Arrays.asList("mongodb", "databases", "nosql"))
				.title("MongoDB для начинающих")
				.type(PostType.PUBLICATION)
				.likes(Arrays.asList(
					Like.builder().handle("JProgrammer").time(LocalDateTime.now()).build(),
					Like.builder().handle("PProgrammer").time(LocalDateTime.now()).build()))
				.build();
			repository.save(mongoForBeginners);

			Post gitForBegginers = Post.builder()
				.id("git_for_beginners")
				.content(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tempor sapien auctor massa luctus, sed blandit purus mollis. Morbi sit amet felis molestie, sagittis eros a, luctus sapien. Integer fringilla euismod finibus. Nunc eget sagittis augue. In pretium velit varius efficitur tincidunt. Phasellus in maximus est, et pulvinar libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque luctus pulvinar enim ut molestie. Mauris euismod suscipit velit et congue. Mauris elit augue, fringilla quis dolor venenatis, vehicula faucibus risus. Aliquam pharetra elit neque, a rhoncus justo consectetur id. Duis commodo a diam ac vulputate. Nunc suscipit gravida enim ac tincidunt. Nunc maximus vitae ante in porttitor."
						+ "Sed neque tortor, mollis non nisl et, bibendum volutpat lectus. Maecenas sed ex egestas, pulvinar leo malesuada, fermentum leo. Morbi eu blandit eros, at ultricies magna. Proin quis magna nunc. Aenean eget dolor imperdiet, porttitor lacus eu, fermentum metus. Fusce molestie, elit ut porttitor aliquam, massa odio semper nisl, ac bibendum sem nisi id lacus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
						+ "Phasellus metus risus, tincidunt tempus lacinia ac, tempor ac tortor. Vivamus blandit accumsan ultrices. Maecenas tincidunt ac ante ut vehicula. Donec tempus imperdiet lorem, quis vulputate felis luctus eu. Nam at diam a mi tincidunt auctor. Donec consectetur mauris in massa luctus, commodo sagittis purus cursus. Nulla sodales neque at imperdiet porttitor. Aenean euismod pretium quam. Nam mattis libero nibh, in tincidunt lacus feugiat vel. Nulla et mauris ut eros vehicula consectetur. Donec non auctor massa. Integer hendrerit varius eleifend. Suspendisse commodo mattis cursus. Donec ultricies posuere sodales. Duis gravida elementum ullamcorper. Nulla euismod tellus sit amet nibh accumsan, et sodales elit elementum."
						+ "Morbi vehicula mattis euismod. Fusce quis sollicitudin libero, vel ornare neque. Sed vehicula tincidunt sem sit amet euismod. Sed id nibh pharetra, sagittis ligula et, semper ipsum. Fusce eu odio placerat, interdum orci at, euismod metus. Donec luctus mauris in urna iaculis lobortis. Integer ut luctus tortor, non tempus mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi sollicitudin rhoncus neque vitae mollis. Praesent in gravida enim. Nam a ullamcorper massa. Nulla sollicitudin, nibh non scelerisque lacinia, erat ligula aliquet est, vitae aliquet tellus dolor ultricies mi. Mauris at bibendum nibh, non porttitor est. Mauris a bibendum massa. Ut congue gravida venenatis. In hac habitasse platea dictumst."
						+ "Nullam eget mollis risus. Curabitur tempor, sapien in vestibulum mollis, eros sem blandit sem, id iaculis tortor purus et ligula. Maecenas rhoncus est dui, at dignissim justo rutrum nec. Nam dictum molestie eros, eu ultrices urna tincidunt at. Nunc iaculis pulvinar nunc. Nullam vel blandit nisi, id blandit velit. Nullam non ipsum id ligula tincidunt molestie. Nunc eu turpis eu nisi vehicula eleifend ut sed nibh. Nullam sed libero malesuada, feugiat ipsum in, congue enim. Nam ante velit, pharetra sed efficitur et, mattis vel nisl. Aenean mattis lacinia dolor sed facilisis. Mauris pretium blandit massa eu dictum. Vestibulum faucibus purus ac orci dignissim tempus. Proin sit amet eros vel nisi ultrices bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum semper feugiat massa ac aliquam."
						+ "Morbi id accumsan ex. Donec ut augue ultricies, viverra felis fermentum, interdum augue. Nam fringilla condimentum eleifend. Donec efficitur, ipsum sit amet blandit porta, urna libero semper lectus, pretium interdum elit libero vitae dolor. Vestibulum commodo dapibus leo sit amet bibendum. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla imperdiet quam ex, id volutpat purus venenatis non. Duis posuere ligula orci, eu consectetur tortor dapibus sit amet. Maecenas enim est, tristique sed nulla sed, tincidunt consequat purus. Quisque mattis rutrum suscipit. Vestibulum ultricies sem convallis laoreet dignissim. Etiam cursus at mauris eu eleifend. Praesent fringilla consequat mi, nec molestie libero gravida ac. Aliquam quis scelerisque nisi, eu consectetur eros."
						+ "Donec vulputate sem feugiat, eleifend turpis sed, ultrices sapien. Etiam sit amet turpis ac erat lacinia rhoncus at vel turpis. Nam dignissim volutpat elit, commodo maximus lacus blandit non. Aenean non finibus metus, ut gravida lorem. Donec dui mauris, interdum a nulla condimentum, volutpat fringilla tellus. Pellentesque eu sem quis mi imperdiet dignissim vitae quis justo. Duis placerat maximus eros posuere tincidunt. Ut laoreet aliquet nibh, nec tempor mauris faucibus tincidunt."
						+ "Mauris nunc tortor, interdum quis mauris sed, tincidunt fermentum turpis. Duis dictum lorem non ornare gravida. Vestibulum sed justo mi. Cras aliquet risus in felis vehicula laoreet in eu velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vestibulum at felis eget ornare. Mauris metus mauris, aliquam at nulla et, auctor egestas lectus."
						+ "Cras varius lobortis dui, vitae efficitur augue volutpat et. Ut mattis massa vel erat scelerisque ullamcorper. Nulla fermentum lectus iaculis justo malesuada, non sagittis est feugiat. Aliquam eu dui et nibh venenatis euismod a sed quam. In porta dui sed leo bibendum suscipit. Aliquam sapien lorem, viverra ac risus nec, lacinia hendrerit ipsum. Donec convallis maximus nisi. Suspendisse viverra nisi porttitor elit luctus ultrices."
						+ "Vestibulum consequat volutpat sem vitae dapibus. Suspendisse tempor, magna et finibus rhoncus, tellus eros egestas ipsum, quis cursus enim ipsum convallis massa. Quisque id libero augue. Integer vehicula sem eu magna euismod, vel viverra diam tristique. Fusce pretium bibendum finibus. Fusce scelerisque est malesuada dui commodo, eget elementum velit elementum. Quisque imperdiet dui quis mauris dignissim, vitae varius orci ultricies. Donec faucibus luctus sem mollis pellentesque. Phasellus mollis libero tortor, in mattis eros blandit et. Cras ligula orci, viverra sed ullamcorper vel, venenatis et diam. Integer ultricies eu ligula ut rhoncus. Duis sit amet suscipit purus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.")
				.image("https://tproger.ru/wp-content/uploads/2015/05/git-logo1.png")
				.lastUpdate(LocalDateTime.now())
				.publicationDate(LocalDate.now())
				.publisher(postMaker)
				.tags(Arrays.asList("git", "cvs"))
				.title("Git для начинающих")
				.type(PostType.PUBLICATION)
				.comments(Arrays
					.asList(
						Comment.builder().author("JProgrammer").content("I know this!").build(),
						Comment.builder().author("PProgrammer").content("I know this!").build()))
				.likes(Arrays.asList(
					Like.builder().handle("JProgrammer").time(LocalDateTime.now()).build(),
					Like.builder().handle("JProgrammer").time(LocalDateTime.now()).build()))
				.build();
			repository.save(gitForBegginers);
		};
	}
}
