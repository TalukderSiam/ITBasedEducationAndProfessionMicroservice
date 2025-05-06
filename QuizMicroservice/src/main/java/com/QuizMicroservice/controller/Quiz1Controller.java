// package com.edupro.EducationWeb.controller;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;

// import com.edupro.EducationWeb.dto.response.RootResponseModel;
// import com.edupro.EducationWeb.entity.CT.CTQuetion;
// import com.edupro.EducationWeb.entity.Quiz.QuizDayDetails;
// import com.edupro.EducationWeb.entity.Quiz.QuizSubject;
// import com.edupro.EducationWeb.service.CloudinaryService;
// import com.edupro.EducationWeb.service.QuizService;
// import com.edupro.EducationWeb.utils.ResponseOfApi;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;



// @RestController
// @RequestMapping("/api/Quiz")
// @CrossOrigin(origins = "*")
// public class Quiz1Controller {

//     @Autowired
//     private QuizService QuizService;

//     @Autowired
//     private CloudinaryService cloudinaryService;

    

//     @PostMapping("Quizsubject/post")
//     public ResponseEntity<RootResponseModel<?>> save(@RequestBody QuizSubject   QuizSubject) {

//         QuizSubject savedQuizSubject= QuizService.save(QuizSubject);

//         RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
//                 true,
//                 "QuizSubject_Post",
//                 "Saved QuizSubject Successfully",
//                 "QuizSubject",
//                 List.of(savedQuizSubject));

     
//         return ResponseEntity.ok(response);
//     }








//     @GetMapping("Quizsubject/getall")
//     public ResponseEntity<RootResponseModel<?>> getAllQuizSubject() {

//        List<QuizSubject>QuizSubjectList= QuizService.getall();
//         RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
//             true,
//             "QuizSubject_Get",
//             "Get QuizSubject List Successfully",
//             "QuizSubjectList",
//             QuizSubjectList);

 
//     return ResponseEntity.ok(response);
//     }

//     @PostMapping("Quizdaydetails/post")
//     public ResponseEntity<RootResponseModel<?>> save( 
//     @RequestParam("QuizQuestionFile") MultipartFile file,
//     @RequestParam("QuizTakenBy") String QuizTakenBy,
//     @RequestParam("FileUploadBy") String fileUploadBy,
//     @RequestParam("NumberOfDay") String numberOfDay,
//     @RequestParam("SubjectName") String subjectName,
//     @RequestParam("IndexName") String indexName) {

//         String fileUrl = cloudinaryService.uploadFile(file);

//           //  CTQuetion question =cTQuetionService.save(fileUrl,courseTakenBy,semester,year,subjectName);

//         QuizDayDetails savedQuizDayDetails= QuizService.save(fileUrl,QuizTakenBy,fileUploadBy,numberOfDay,subjectName,indexName);

//         RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
//                 true,
//                 "QuizSubject_Post",
//                 "Saved QuizSubject Successfully",
//                 "QuizSubject",
//                 List.of(savedQuizDayDetails));

     
//         return ResponseEntity.ok(response);
//     }

//     @GetMapping("Quizdaydetails/getbysubjectnameandnumberofday")
//     public ResponseEntity<RootResponseModel<?>> getbysubjectnameandnumberofday(@RequestParam String SubjectName , @RequestParam String NumberOfDay) {

//         List<QuizDayDetails> savedQuizDayDetails= QuizService.getbysubjectnameandnumberofday(SubjectName,NumberOfDay);

//         RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
//                 true,
//                 "QuizSubject_Post",
//                 "Saved QuizSubject Successfully",
//                 "QuizSubject",
//                 List.of(savedQuizDayDetails));

     
//         return ResponseEntity.ok(response);
//     }

 

    
// }
