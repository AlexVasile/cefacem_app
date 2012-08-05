package net.cefacem.app.service;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import net.cefacem.app.model.Post;

@Service
public class PostComparatorByDate implements Comparator<Post> {

	@Override
	public int compare(Post o1, Post o2) {
		if (o1.getEventDateTime().equals(o2.getEventDateTime()))
			return 0;
		else if (o1.getEventDateTime().after(o2.getEventDateTime())) 
			return -1;
		else 
			return 1;
	}

}
