package net.cefacem.app.service;

import java.util.Comparator;

import net.cefacem.app.model.Post;

public class PostComparator implements Comparator<Post> {

	@Override
	public int compare(Post o1, Post o2) {
		if (o2.getScore() == o1.getScore()) 
			return 0;
		else if (o2.getScore() - o1.getScore() < 0)
			return -1;
		else
			return 1;
	}

}
