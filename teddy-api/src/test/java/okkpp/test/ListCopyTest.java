package okkpp.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import okkpp.dto.PostDTO;
import okkpp.model.Post;

public class ListCopyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Post> source = new ArrayList<>();
		Post post = new Post();
		post.setId(1L);
		post.setSummary("this is a test");
		source.add(post);
		
		List<PostDTO> target = new ArrayList<>();
		BeanUtils.copyProperties(source, target);
//		ListCopyTest instantiateClass = BeanUtils.instantiateClass(ListCopyTest.class);
		
		System.out.println(source);
		System.out.println(target);
	}

}
