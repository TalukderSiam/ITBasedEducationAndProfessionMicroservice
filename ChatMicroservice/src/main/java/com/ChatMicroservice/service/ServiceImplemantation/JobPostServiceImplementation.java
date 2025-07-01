package com.ChatMicroservice.service.ServiceImplemantation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.ChatMicroservice.dto.response.JobSiteResponse;
import com.ChatMicroservice.entity.JobPost;
import com.ChatMicroservice.exception.CustomRuntimeException;
import com.ChatMicroservice.service.JobPostService;

@Service
public class JobPostServiceImplementation implements JobPostService {

    public List<JobSiteResponse> getAllJobPosts() {
        List<JobSiteResponse> allSources = new ArrayList<>();

        System.out.println();
        System.out.println("i got call ");
        System.out.println();

        allSources.add(new JobSiteResponse("CareerJet", scrapeCareerJet()));
        allSources.add(new JobSiteResponse("BdJobs", scrapeBdJobs()));
        allSources.add(new JobSiteResponse("AnotherSite", scrapeAnotherSite()));

        return allSources;
    }

    private List<JobPost> scrapeCareerJet() {
        List<JobPost> jobPosts = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://www.careerjet.com.bd/software-engineer-jobs").get();
            Elements jobElements = doc.select(".job");

            for (Element job : jobElements) {
                String title = job.select("h2 > a").text();
                String link = "https://www.careerjet.com.bd/" + job.select("h2 > a").attr("href");
                String company = job.select("p.company").text();
                String location = job.select("ul.location li").text();
                String description = job.select("div.desc").text();
                String posted = job.select("ul.tags li span.badge").first() != null
                        ? job.select("ul.tags li span.badge").first().text()
                        : "Not specified";

                jobPosts.add(new JobPost(title, link, company, location, description, posted));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomRuntimeException(false, e.getMessage(), "Message_Post",
                    "Message", List.of());

        }

        jobPosts.sort(Comparator.comparingInt(post -> convertPostedToDays(post.getPostedTime())));
        return jobPosts;
    }

    private List<JobPost> scrapeBdJobs() {
        List<JobPost> jobPosts = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://jobs.bdjobs.com/jobsearch.asp?fcatId=8&icatId").get();
            Elements jobElements = doc.select(".sout-jobs-wrapper");
            

            for (Element job : jobElements) {

            //     System.err.println();
            //    System.err.println(job.html());
            //    System.err.println();

                String title = job.select("div.job-title-text a").text();

                String link = job.select("div.job-title-text a").attr("href");

                String company = job.select("div.comp-name-text").text();
                
                String location = job.select("div.locon-text-d").text();
                String description = job.select("div.promo-text").text();
                 String posted = "2 day ago";

                // Element locationDiv = job.select("div.loccal, div.locon-text-d").first();
                // String location = "Not specified";

                // if (locationDiv != null) {
                //     Element locationP = locationDiv.selectFirst("p");
                //     if (locationP != null) {
                //         location = locationP.ownText().trim();
                //         // System.err.println("Location HTML: " + locationDiv.html());
                //         // System.err.println("Extracted Location: " + location);
                //     } else {
                //         System.err.println("Location <p> tag not found.");
                //     }
                // } else {
                //     System.err.println("Location <div.local> not found.");
                // }

                // String description = job.select("div.promo-text").text();
                // String posted = "";

                // System.out.println("🔽 Extracted Job Info:");
                // System.out.println("Title      : " + title);
                // System.out.println("Link       : " + link);
                // System.out.println("Company    : " + company);
                // // System.out.println("Location   : " + location);
                // // System.out.println("Description: " + description);
                // // System.out.println("Posted     : " + posted);
                // System.out.println("--------------------------------------------------");

                jobPosts.add(new JobPost(title, link, company, location, description, posted));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobPosts;

    }

    private List<JobPost> scrapeAnotherSite() {
        List<JobPost> jobPosts = new ArrayList<>();
        // Write your logic here as in previous example
        return jobPosts;
    }

    private int convertPostedToDays(String posted) {
        if (posted == null || posted.trim().isEmpty())
            return Integer.MAX_VALUE;

        posted = posted.toLowerCase();

        if (posted.contains("just posted") || posted.contains("today"))
            return 0;
        if (posted.contains("yesterday"))
            return 1;

        // Example: "2 days ago", "3+ days ago"
        Matcher matcher = Pattern.compile("(\\d+)\\+?\\s+day").matcher(posted);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return Integer.MAX_VALUE; // Unknown or "Not specified"
    }

}
