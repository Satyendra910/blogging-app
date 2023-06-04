package com.javaworld.service.impl;

import com.javaworld.entities.Post;
import com.javaworld.payload.PostDto;
import com.javaworld.repository.PostRepository;
import com.javaworld.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = toPost(postDto);

        Post saved = postRepository.save(post);

        return toPostDto(saved);
    }

    Post toPost(PostDto postDto){
        return modelMapper.map(postDto,Post.class);
    }

    PostDto toPostDto(Post post){
        return modelMapper.map(post,PostDto.class);
    }

}
