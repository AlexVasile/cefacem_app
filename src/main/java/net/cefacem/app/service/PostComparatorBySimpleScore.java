package net.cefacem.app.service;

import java.util.Comparator;

import net.cefacem.app.model.Post;

import org.springframework.stereotype.Service;

@Service
public class PostComparatorBySimpleScore implements Comparator<Post> {

	@Override
	public int compare(Post o1, Post o2) {
		return o2.getSimpleScore() - o1.getSimpleScore();
	}

}
