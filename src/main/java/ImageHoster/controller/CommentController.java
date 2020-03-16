

package ImageHoster.controller;


import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/image/{imageID}/{title}/comments")
    public String createComment(@RequestParam(name = "comments") String text, @PathVariable(name = "imageID") int imageId, Model model, HttpSession session, @PathVariable(name="title") String imageTitle){
        Comment comment = new Comment();
        comment.setImage(imageService.getImage(imageId));
        comment.setCreatedDate(LocalDate.now());
        User user = (User) session.getAttribute("loggeduser");
        comment.setUser(user);
        comment.setText(text);
        commentService.createComment(comment);
        Image image = imageService.getImage(imageId);
        model.addAttribute("image",image);
        model.addAttribute("tags", image.getTags());
        model.addAttribute("comments",image.getComments());
        return "redirect:/images/{imageID}/{title}";
    }
}


