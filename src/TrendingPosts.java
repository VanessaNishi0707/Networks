import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TrendingPosts {

    // Calculate the rate of views or comments per hour for a given post
    public static double calculateTrendingScore(Post post, boolean byViews) {
        long elapsedTimeInMillis = new Date().getTime() - post.getCreationTime().getTime();
        long elapsedTimeInHours = elapsedTimeInMillis / (1000 * 60 * 60); // Convert ms to hours
        if (elapsedTimeInHours == 0) elapsedTimeInHours = 1; // Avoid division by zero

        if (byViews) {
            return (double) post.getViewCount() / elapsedTimeInHours;
        } else {
            return (double) post.getCommentCount() / elapsedTimeInHours;
        }
    }

    // Generate a report of trending posts based on views or comments
    public static List<Post> getTrendingPosts(List<Post> posts, boolean byViews) {
        // Sort posts by their trending score (views or comments per hour)
        posts.sort((p1, p2) -> Double.compare(calculateTrendingScore(p2, byViews), calculateTrendingScore(p1, byViews)));
        return posts;
    }

    // Filter posts based on keywords
    public static List<Post> filterPostsByKeyword(List<Post> posts, List<String> keywords, boolean include) {
        return posts.stream()
                .filter(post -> {
                    boolean containsKeyword = keywords.stream().anyMatch(keyword -> post.getContent().toLowerCase().contains(keyword.toLowerCase()));
                    return include ? containsKeyword : !containsKeyword;
                })
                .collect(Collectors.toList());
    }

    // Filter posts based on user attributes
    public static List<Post> filterPostsByUserAttributes(List<Post> posts, Integer age, String gender, String region) {
        return posts.stream()
                .filter(post -> {
                    User user = post.getUser();
                    boolean matches = true;
                    if (age != null) {
                        matches = matches && user.getAge() == age;
                    }
                    if (gender != null) {
                        matches = matches && user.getGender().equalsIgnoreCase(gender);
                    }
                    if (region != null) {
                        matches = matches && user.getRegion().equalsIgnoreCase(region);
                    }
                    return matches;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Example users
        User user1 = new User("user1", 25, "male", "USA");
        User user2 = new User("user2", 30, "female", "Canada");

        // Example posts
        Post post1 = new Post("Post about Java programming", new Date(System.currentTimeMillis() - 1000000000), user1); // Created 1 day ago
        Post post2 = new Post("Post about Python programming", new Date(System.currentTimeMillis() - 500000000), user2); // Created 12 hours ago

        // Adding views to the posts
        post1.addView(new View(new Date(System.currentTimeMillis() - 100000000))); // View 1
        post1.addView(new View(new Date(System.currentTimeMillis() - 200000000))); // View 2
        post2.addView(new View(new Date(System.currentTimeMillis() - 30000000))); // View 3

        // Adding comments to the posts
        post1.addComment(new Comment(user1, "Great post!", new Date(System.currentTimeMillis() - 500000000)));
        post2.addComment(new Comment(user2, "Very informative!", new Date(System.currentTimeMillis() - 10000000)));

        // Add posts to a list
        List<Post> posts = Arrays.asList(post1, post2);

        // Filter posts by keyword
        List<String> keywords = Arrays.asList("Java");
        List<Post> filteredPosts = filterPostsByKeyword(posts, keywords, true);
        System.out.println("Filtered posts containing keywords:");
        for (Post post : filteredPosts) {
            System.out.println(post.getContent());
        }

        // Filter posts by user attributes
        List<Post> filteredByUserAttributes = filterPostsByUserAttributes(posts, 25, "male", null);
        System.out.println("\nFiltered posts by user attributes:");
        for (Post post : filteredByUserAttributes) {
            System.out.println(post.getContent());
        }

        // Get trending posts by views
        List<Post> trendingPostsByViews = getTrendingPosts(posts, true);
        System.out.println("\nTrending posts by views:");
        for (Post post : trendingPostsByViews) {
            System.out.println(post.getContent() + " - Views: " + post.getViewCount());
        }

        // Get trending posts by comments
        List<Post> trendingPostsByComments = getTrendingPosts(posts, false);
        System.out.println("\nTrending posts by comments:");
        for (Post post : trendingPostsByComments) {
            System.out.println(post.getContent() + " - Comments: " + post.getCommentCount());
        }
    }
}