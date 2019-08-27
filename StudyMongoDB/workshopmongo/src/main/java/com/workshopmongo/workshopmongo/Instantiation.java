package com.workshopmongo.workshopmongo;

import com.workshopmongo.workshopmongo.domain.Post;
import com.workshopmongo.workshopmongo.domain.User;
import com.workshopmongo.workshopmongo.dto.AuthorDTO;
import com.workshopmongo.workshopmongo.dto.ComentDTO;
import com.workshopmongo.workshopmongo.repository.PostRepository;
import com.workshopmongo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postReposiroty;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userReposiroty.deleteAll();
        postReposiroty.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!");
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!");

        post1.setAuthor(new AuthorDTO(maria));
        post2.setAuthor(new AuthorDTO(maria));

        ComentDTO comentDTO1 = new ComentDTO("Boa viagem", sdf.parse("27/08/2019"), new AuthorDTO(alex));
        ComentDTO comentDTO2 = new ComentDTO("Bom dia", sdf.parse("27/08/2019"), new AuthorDTO(bob));

        post1.getComentDTOS().addAll(Arrays.asList(comentDTO1));
        post2.getComentDTOS().addAll(Arrays.asList(comentDTO2));

        postReposiroty.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userReposiroty.save(maria);
    }

}
