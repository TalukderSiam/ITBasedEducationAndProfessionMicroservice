package com.ChatMicroservice.service.ServiceImplemantation;

import java.util.ArrayList;
import java.util.List;



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
public class JobPostServiceImplementation implements JobPostService{

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
        return jobPosts;
    }

    private List<JobPost> scrapeBdJobs() {
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
        }
        return jobPosts;
       
    }

    private List<JobPost> scrapeAnotherSite() {
        List<JobPost> jobPosts = new ArrayList<>();
        // Write your logic here as in previous example
        return jobPosts;
    }
    
}
