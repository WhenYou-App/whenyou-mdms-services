package com.whenyou.masterdata.service;

import com.whenyou.masterdata.entity.MDistrict;
import com.whenyou.masterdata.entity.MPincode;
import com.whenyou.masterdata.excelutil.ExcelUtility;
import com.whenyou.masterdata.model.Message;
import com.whenyou.masterdata.repository.MDistrictRepository;
import com.whenyou.masterdata.repository.MPincodeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InitService {
    @Autowired MasterDataService masterDataService;

//    public Message createInitialData() throws ParseException {
//        if (!masterDataService.isDistrictsAvailable()) createDistricts();
//        return Message.builder().message("Initial data created successfully").status(true).build();
//    }
//
//    public void createDistricts() {
//        List<MDistrict> mDistricts = new ArrayList<>();
//        mDistricts.add(MDistrict.builder().id(1L).name("Thiruvananthapuram").nameInLocal("തിരുവനന്തപുരം").status(true).build());
//        mDistricts.add(MDistrict.builder().id(2L).name("Kollam").nameInLocal("കൊല്ലം").status(true).build());
//        mDistricts.add(MDistrict.builder().id(3L).name("Pathanamthitta").nameInLocal("പത്തനംതിട്ട").status(true).build());
//        mDistricts.add(MDistrict.builder().id(4L).name("Alappuzha").nameInLocal("ആലപ്പുഴ").status(true).build());
//        mDistricts.add(MDistrict.builder().id(5L).name("Kottayam").nameInLocal("കോട്ടയം").status(true).build());
//        mDistricts.add(MDistrict.builder().id(6L).name("Idukki").nameInLocal("ഇടുക്കി").status(true).build());
//        mDistricts.add(MDistrict.builder().id(7L).name("Ernakulam").nameInLocal("എറണാകുളം").status(true).build());
//        mDistricts.add(MDistrict.builder().id(8L).name("Thrissur").nameInLocal("തൃശ്ശൂർ").status(true).build());
//        mDistricts.add(MDistrict.builder().id(9L).name("Palakkad").nameInLocal("പാലക്കാട്").status(true).build());
//        mDistricts.add(MDistrict.builder().id(10L).name("Malappuram").nameInLocal("മലപ്പുറം").status(true).build());
//        mDistricts.add(MDistrict.builder().id(11L).name("Kozhikode").nameInLocal("കോഴിക്കോട്").status(true).build());
//        mDistricts.add(MDistrict.builder().id(12L).name("Wayanad").nameInLocal("വയനാട്").status(true).build());
//        mDistricts.add(MDistrict.builder().id(13L).name("Kannur").nameInLocal("കണ്ണൂർ").status(true).build());
//        mDistricts.add(MDistrict.builder().id(14L).name("Kasaragod").nameInLocal("കാസർഗോഡ്").status(true).build());
//        masterDataService.createDistricts(mDistricts);
//    }

//    public void createPincodes() {
//        List<MPincode> mPincodes = new ArrayList<>();
//
//        // Adding the provided data into the mPincodes list
//        mPincodes.add(MPincode.builder().id(1L).name("Adayamon").nameInLocal("അടയമൺ").pincode("695614").status(true).build());
//        mPincodes.add(MPincode.builder().id(2L).name("Alamcode").nameInLocal("ആലംകോട്").pincode("695102").status(true).build());
//        mPincodes.add(MPincode.builder().id(3L).name("Aliyadu").nameInLocal("അലിയാട്").pincode("695607").status(true).build());
//        mPincodes.add(MPincode.builder().id(4L).name("Altharamoodu").nameInLocal("ആൽത്തറമൂട്").pincode("695102").status(true).build());
//        mPincodes.add(MPincode.builder().id(5L).name("Amachal").nameInLocal("ആമച്ചൽ").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(6L).name("Amaravila").nameInLocal("അമരവിള").pincode("695122").status(true).build());
//        mPincodes.add(MPincode.builder().id(7L).name("Ambalamukku").nameInLocal("അമ്പലമുക്ക്").pincode("695005").status(true).build());
//        mPincodes.add(MPincode.builder().id(8L).name("Ambalathara").nameInLocal("അമ്പലത്തറ").pincode("695026").status(true).build());
//        mPincodes.add(MPincode.builder().id(9L).name("Ambalathinkala").nameInLocal("അമ്പലത്തിങ്കല").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(10L).name("Amboori").nameInLocal("അമ്പൂരി").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(11L).name("Anad").nameInLocal("ആനാട്").pincode("695541").status(true).build());
//        mPincodes.add(MPincode.builder().id(12L).name("Anakudy").nameInLocal("ആനക്കുടി").pincode("695606").status(true).build());
//        mPincodes.add(MPincode.builder().id(13L).name("Anappara").nameInLocal("ആനപ്പാറ").pincode("695551").status(true).build());
//        mPincodes.add(MPincode.builder().id(14L).name("Anathalavattom").nameInLocal("ആനത്തലവട്ടം").pincode("695306").status(true).build());
//        mPincodes.add(MPincode.builder().id(15L).name("Anavoor").nameInLocal("ആനാവൂർ").pincode("695124").status(true).build());
//        mPincodes.add(MPincode.builder().id(16L).name("Anayara").nameInLocal("ആനയറ").pincode("695029").status(true).build());
//        mPincodes.add(MPincode.builder().id(17L).name("Andoorkonam").nameInLocal("അണ്ടൂർക്കോണം").pincode("695584").status(true).build());
//        mPincodes.add(MPincode.builder().id(18L).name("Anjengo").nameInLocal("അൻജെങ്കോ").pincode("695309").status(true).build());
//        mPincodes.add(MPincode.builder().id(19L).name("Aralumoodu").nameInLocal("ആറാലുംമൂട്").pincode("695123").status(true).build());
//        mPincodes.add(MPincode.builder().id(20L).name("Aramada").nameInLocal("അരമഡ").pincode("695032").status(true).build());
//        mPincodes.add(MPincode.builder().id(21L).name("Arayur").nameInLocal("ആറയൂർ").pincode("695122").status(true).build());
//        mPincodes.add(MPincode.builder().id(22L).name("Arumanoor").nameInLocal("അരുമാനൂർ").pincode("695525").status(true).build());
//        mPincodes.add(MPincode.builder().id(23L).name("Aruvikara").nameInLocal("അരുവിക്കര").pincode("695564").status(true).build());
//        mPincodes.add(MPincode.builder().id(24L).name("Aruvipuram").nameInLocal("അരുവിപ്പുറം").pincode("695126").status(true).build());
//        mPincodes.add(MPincode.builder().id(25L).name("Aryanad").nameInLocal("ആര്യനാട്").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(26L).name("Attakulangara").nameInLocal("അട്ടക്കുളങ്ങര").pincode("695023").status(true).build());
//        mPincodes.add(MPincode.builder().id(27L).name("Attingal").nameInLocal("ആറ്റിങ്ങൽ").pincode("695101").status(true).build());
//        mPincodes.add(MPincode.builder().id(28L).name("Attukkal").nameInLocal("ആറ്റുകാൽ").pincode("695009").status(true).build());
//        mPincodes.add(MPincode.builder().id(29L).name("Avanavancherry").nameInLocal("അവനവഞ്ചേരി").pincode("695103").status(true).build());
//        mPincodes.add(MPincode.builder().id(30L).name("Ayilam").nameInLocal("അയിലം").pincode("695103").status(true).build());
//        mPincodes.add(MPincode.builder().id(31L).name("Ayira").nameInLocal("അയിര").pincode("695502").status(true).build());
//        mPincodes.add(MPincode.builder().id(32L).name("Ayroor-varkala").nameInLocal("അയിരൂർ-വർക്കല").pincode("695310").status(true).build());
//        mPincodes.add(MPincode.builder().id(33L).name("Azhurmarket").nameInLocal("അഴൂർമാർക്കറ്റ്").pincode("695305").status(true).build());
//        mPincodes.add(MPincode.builder().id(34L).name("Balaramapuram").nameInLocal("ബാലരാമപുരം").pincode("695501").status(true).build());
//        mPincodes.add(MPincode.builder().id(35L).name("Beemapally").nameInLocal("ബീമാപള്ളി").pincode("695008").status(true).build());
//        mPincodes.add(MPincode.builder().id(36L).name("Bhagavathinada").nameInLocal("ഭഗവതിനട").pincode("695501").status(true).build());
//        mPincodes.add(MPincode.builder().id(37L).name("Bharathannur").nameInLocal("ഭരതന്നൂർ").pincode("695609").status(true).build());
//        mPincodes.add(MPincode.builder().id(38L).name("Bonaccord").nameInLocal("ബോണക്കോർഡ്").pincode("695551").status(true).build());
//        mPincodes.add(MPincode.builder().id(39L).name("Cgo Complex Poonkulam").nameInLocal("Cgo കോംപ്ലക്സ് പൂങ്കുളം").pincode("695522").status(true).build());
//        mPincodes.add(MPincode.builder().id(40L).name("Chaikkottukonam").nameInLocal("ചായക്കോട്ടുകോണം").pincode("695122").status(true).build());
//        mPincodes.add(MPincode.builder().id(41L).name("Chakkai").nameInLocal("ചക്കൈ").pincode("695024").status(true).build());
//        mPincodes.add(MPincode.builder().id(42L).name("Changa").nameInLocal("ചങ്ങ").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(43L).name("Channamkara").nameInLocal("ചന്നംകര").pincode("695301").status(true).build());
//        mPincodes.add(MPincode.builder().id(44L).name("Charupara").nameInLocal("ചാരുപാറ").pincode("695601").status(true).build());
//        mPincodes.add(MPincode.builder().id(45L).name("Cheeranikkara").nameInLocal("ചീരനിക്കര").pincode("695615").status(true).build());
//        mPincodes.add(MPincode.builder().id(46L).name("Chekkakonam").nameInLocal("ചെക്കക്കോണം").pincode("695564").status(true).build());
//        mPincodes.add(MPincode.builder().id(47L).name("Chempazhanthy").nameInLocal("ചെമ്പഴന്തി").pincode("695587").status(true).build());
//        mPincodes.add(MPincode.builder().id(48L).name("Chenkal").nameInLocal("ചെങ്കൽ").pincode("695132").status(true).build());
//        mPincodes.add(MPincode.builder().id(49L).name("Cheriakolla").nameInLocal("ചെറിയകൊല്ല").pincode("695504").status(true).build());
//        mPincodes.add(MPincode.builder().id(50L).name("Cheriyakonni").nameInLocal("ചെറിയകൊന്നി").pincode("695013").status(true).build());
//        mPincodes.add(MPincode.builder().id(51L).name("Cherunniyur").nameInLocal("ചെറുന്നിയൂർ").pincode("695142").status(true).build());
//        mPincodes.add(MPincode.builder().id(52L).name("Cheruvallimukku").nameInLocal("ചെറുവള്ളിമുക്ക്").pincode("695304").status(true).build());
//        mPincodes.add(MPincode.builder().id(53L).name("Cheruvarakonam").nameInLocal("ചെറുവാരക്കോണം").pincode("695502").status(true).build());
//        mPincodes.add(MPincode.builder().id(54L).name("Cheruvikkal").nameInLocal("ചെറുവിക്കൽ").pincode("695011").status(true).build());
//        mPincodes.add(MPincode.builder().id(55L).name("Chettachal").nameInLocal("ചെറ്റച്ചൽ").pincode("695551").status(true).build());
//        mPincodes.add(MPincode.builder().id(56L).name("Chilakur").nameInLocal("ചിലക്കൂർ").pincode("695141").status(true).build());
//        mPincodes.add(MPincode.builder().id(57L).name("Chirayinkeezhu").nameInLocal("ചിറയിൻകീഴ്").pincode("695304").status(true).build());
//        mPincodes.add(MPincode.builder().id(58L).name("Chittattumukku").nameInLocal("ചിറ്റാട്ടുമുക്ക്").pincode("695301").status(true).build());
//        mPincodes.add(MPincode.builder().id(59L).name("Chowara").nameInLocal("ചൊവ്വര").pincode("695501").status(true).build());
//        mPincodes.add(MPincode.builder().id(60L).name("Chullimanoor").nameInLocal("ചുള്ളിമാനൂർ").pincode("695541").status(true).build());
//        mPincodes.add(MPincode.builder().id(61L).name("Cotton Hill").nameInLocal("കോട്ടൺ ഹിൽ").pincode("695014").status(true).build());
//        mPincodes.add(MPincode.builder().id(62L).name("Daivapura").nameInLocal("ദൈവപുര").pincode("695563").status(true).build());
//        mPincodes.add(MPincode.builder().id(63L).name("Dalmughom").nameInLocal("ദാൽമുഖം").pincode("695125").status(true).build());
//        mPincodes.add(MPincode.builder().id(64L).name("Dhanuvachapuram").nameInLocal("ധനുവച്ചപുരം").pincode("695503").status(true).build());
//        mPincodes.add(MPincode.builder().id(65L).name("Edakode").nameInLocal("എടക്കോട്").pincode("695104").status(true).build());
//        mPincodes.add(MPincode.builder().id(66L).name("Edava").nameInLocal("ഇടവ").pincode("695311").status(true).build());
//        mPincodes.add(MPincode.builder().id(67L).name("Elakamon").nameInLocal("ഇലകമൺ").pincode("695310").status(true).build());
//        mPincodes.add(MPincode.builder().id(68L).name("Elakamon-kizhakkepuram").nameInLocal("ഇലകമൺ-കിഴക്കേപ്പുറം").pincode("695310").status(true).build());
//        mPincodes.add(MPincode.builder().id(69L).name("Elavattom").nameInLocal("എളവട്ടം").pincode("695562").status(true).build());
//        mPincodes.add(MPincode.builder().id(70L).name("Elluvila").nameInLocal("എള്ളുവിള").pincode("695504").status(true).build());
//        mPincodes.add(MPincode.builder().id(71L).name("Ex-servicemen's Colony").nameInLocal("വിമുക്തഭടന്മാരുടെ കോളനി").pincode("695562").status(true).build());
//        mPincodes.add(MPincode.builder().id(72L).name("Goureesapattom").nameInLocal("ഗൗരീശപട്ടം").pincode("695004").status(true).build());
//        mPincodes.add(MPincode.builder().id(73L).name("Hariharapuram").nameInLocal("ഹരിഹരപുരം").pincode("695310").status(true).build());
//        mPincodes.add(MPincode.builder().id(74L).name("Idinjar").nameInLocal("ഇടിഞ്ഞാർ").pincode("695563").status(true).build());
//        mPincodes.add(MPincode.builder().id(75L).name("Ilamba").nameInLocal("ഇളംബ").pincode("695103").status(true).build());
//        mPincodes.add(MPincode.builder().id(76L).name("Ilanchiyam").nameInLocal("ഇലഞ്ചിയം").pincode("695563").status(true).build());
//        mPincodes.add(MPincode.builder().id(77L).name("Industrial Estate").nameInLocal("ഇൻഡസ്ട്രിയൽ എസ്റ്റേറ്റ്").pincode("695019").status(true).build());
//        mPincodes.add(MPincode.builder().id(78L).name("Irinchayam").nameInLocal("ഇരിഞ്ചയം").pincode("695561").status(true).build());
//        mPincodes.add(MPincode.builder().id(79L).name("Iroopara").nameInLocal("ഇരൂപ്പാറ").pincode("695584").status(true).build());
//        mPincodes.add(MPincode.builder().id(80L).name("Jagathy").nameInLocal("ജഗതി").pincode("695014").status(true).build());
//        mPincodes.add(MPincode.builder().id(81L).name("Janardhanapuram").nameInLocal("ജനാർദ്ദനപുരം").pincode("695141").status(true).build());
//        mPincodes.add(MPincode.builder().id(82L).name("Kadakkavur").nameInLocal("കടയ്ക്കാവൂർ").pincode("695306").status(true).build());
//        mPincodes.add(MPincode.builder().id(83L).name("Kaikara").nameInLocal("കായിക്കര").pincode("695307").status(true).build());
//        mPincodes.add(MPincode.builder().id(84L).name("Kaimanam").nameInLocal("കൈമനം").pincode("695040").status(true).build());
//        mPincodes.add(MPincode.builder().id(85L).name("Kaithamukku").nameInLocal("കൈതമുക്ക്").pincode("695024").status(true).build());
//        mPincodes.add(MPincode.builder().id(86L).name("Kakkavila").nameInLocal("കാക്കവിള").pincode("695506").status(true).build());
//        mPincodes.add(MPincode.builder().id(87L).name("Kalamachal").nameInLocal("കളമച്ചൽ").pincode("695606").status(true).build());
//        mPincodes.add(MPincode.builder().id(88L).name("Kallambalam").nameInLocal("കല്ലമ്പലം").pincode("695605").status(true).build());
//        mPincodes.add(MPincode.builder().id(89L).name("Kallar Tvm").nameInLocal("കള്ളാർ ടി.വി.എം").pincode("695551").status(true).build());
//        mPincodes.add(MPincode.builder().id(90L).name("Kallara").nameInLocal("കല്ലറ").pincode("695608").status(true).build());
//        mPincodes.add(MPincode.builder().id(91L).name("Kallayam").nameInLocal("കല്ലയം").pincode("695043").status(true).build());
//        mPincodes.add(MPincode.builder().id(92L).name("Kalliyal").nameInLocal("കല്ലിയാൽ").pincode("695574").status(true).build());
//        mPincodes.add(MPincode.builder().id(93L).name("Kalliyoor").nameInLocal("കല്ലിയൂർ").pincode("695042").status(true).build());
//        mPincodes.add(MPincode.builder().id(94L).name("Kanchinada").nameInLocal("കാഞ്ചിനട").pincode("695609").status(true).build());
//        mPincodes.add(MPincode.builder().id(95L).name("Kandala").nameInLocal("കണ്ടല").pincode("695512").status(true).build());
//        mPincodes.add(MPincode.builder().id(96L).name("Kandukrishi").nameInLocal("കണ്ടുകൃഷി").pincode("695104").status(true).build());
//        mPincodes.add(MPincode.builder().id(97L).name("Kaniyapuram").nameInLocal("കണിയാപുരം").pincode("695301").status(true).build());
//        mPincodes.add(MPincode.builder().id(98L).name("Kanjampazhanji").nameInLocal("കാഞ്ഞമ്പഴഞ്ഞി").pincode("695525").status(true).build());
//        mPincodes.add(MPincode.builder().id(99L).name("Kanjiramkulam").nameInLocal("കാഞ്ഞിരംകുളം").pincode("695524").status(true).build());
//        mPincodes.add(MPincode.builder().id(100L).name("Kanjirampara").nameInLocal("കാഞ്ഞിരംപാറ").pincode("695030").status(true).build());
//        mPincodes.add(MPincode.builder().id(101L).name("Kappil").nameInLocal("കാപ്പിൽ").pincode("695311").status(true).build());
//        mPincodes.add(MPincode.builder().id(102L).name("Karakonam").nameInLocal("കാരക്കോണം").pincode("695504").status(true).build());
//        mPincodes.add(MPincode.builder().id(103L).name("Karakulam").nameInLocal("കരകുളം").pincode("695564").status(true).build());
//        mPincodes.add(MPincode.builder().id(104L).name("Karamana").nameInLocal("കരമന").pincode("695002").status(true).build());
//        mPincodes.add(MPincode.builder().id(105L).name("Karavaram").nameInLocal("കരവാരം").pincode("695605").status(true).build());
//        mPincodes.add(MPincode.builder().id(106L).name("Karikkakom").nameInLocal("കരിക്കകം").pincode("695021").status(true).build());
//        mPincodes.add(MPincode.builder().id(107L).name("Karikuzhi").nameInLocal("കാരിക്കുഴി").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(108L).name("Karimanal").nameInLocal("കരിമണൽ").pincode("695583").status(true).build());
//        mPincodes.add(MPincode.builder().id(109L).name("Karimancode").nameInLocal("കരിമൻകോട്").pincode("695562").status(true).build());
//        mPincodes.add(MPincode.builder().id(110L).name("Karimkuttikara").nameInLocal("കരിംകുട്ടിക്കര").pincode("695606").status(true).build());
//        mPincodes.add(MPincode.builder().id(111L).name("Karipur").nameInLocal("കരിപ്പൂർ").pincode("695541").status(true).build());
//        mPincodes.add(MPincode.builder().id(112L).name("Karode").nameInLocal("കരോഡ്").pincode("695506").status(true).build());
//        mPincodes.add(MPincode.builder().id(113L).name("Karumom").nameInLocal("കരുമോം").pincode("695002").status(true).build());
//        mPincodes.add(MPincode.builder().id(114L).name("Karyavattom").nameInLocal("കാര്യവട്ടം").pincode("695581").status(true).build());
//        mPincodes.add(MPincode.builder().id(115L).name("Katakam").nameInLocal("കടകം").pincode("695304").status(true).build());
//        mPincodes.add(MPincode.builder().id(116L).name("Kattachalkuzhy").nameInLocal("കട്ടച്ചൽക്കുഴി").pincode("695501").status(true).build());
//        mPincodes.add(MPincode.builder().id(117L).name("Kattacode").nameInLocal("കട്ടക്കോട്").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(118L).name("Kattaikonam").nameInLocal("കാട്ടായിക്കോണം").pincode("695584").status(true).build());
//        mPincodes.add(MPincode.builder().id(119L).name("Kattakada").nameInLocal("കാട്ടാക്കട").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(120L).name("Kattumpuram").nameInLocal("കാട്ടുംപുറം").pincode("695608").status(true).build());
//        mPincodes.add(MPincode.builder().id(121L).name("Kaudiar").nameInLocal("കൗഡിയർ").pincode("695003").status(true).build());
//        mPincodes.add(MPincode.builder().id(122L).name("Kaudiar Square").nameInLocal("കൌഡിയർ സ്ക്വയർ").pincode("695003").status(true).build());
//        mPincodes.add(MPincode.builder().id(123L).name("Kavalayur").nameInLocal("കവലയൂർ").pincode("695144").status(true).build());
//        mPincodes.add(MPincode.builder().id(124L).name("Kazhakuttam").nameInLocal("കഴക്കൂട്ടം").pincode("695582").status(true).build());
//        mPincodes.add(MPincode.builder().id(125L).name("Kazhavur").nameInLocal("കഴവൂർ").pincode("695526").status(true).build());
//        mPincodes.add(MPincode.builder().id(126L).name("Keezharur").nameInLocal("കീഴാറൂർ").pincode("695124").status(true).build());
//        mPincodes.add(MPincode.builder().id(127L).name("Keezhattingal").nameInLocal("കീഴാറ്റിങ്ങൽ").pincode("695306").status(true).build());
//        mPincodes.add(MPincode.builder().id(128L).name("Keezhavur").nameInLocal("കീഴാവൂർ").pincode("695584").status(true).build());
//        mPincodes.add(MPincode.builder().id(129L).name("Kerala Governor's Camp").nameInLocal("കേരള ഗവർണറുടെ ക്യാമ്പ്").pincode("695099").status(true).build());
//        mPincodes.add(MPincode.builder().id(130L).name("Kidarakuzhy").nameInLocal("കിടാരക്കുഴി").pincode("695523").status(true).build());
//        mPincodes.add(MPincode.builder().id(131L).name("Kilimanur Palace").nameInLocal("കിളിമാനൂർ കൊട്ടാരം").pincode("695601").status(true).build());
//        mPincodes.add(MPincode.builder().id(132L).name("Kilmanur").nameInLocal("കിൽമാനൂർ").pincode("695601").status(true).build());
//        mPincodes.add(MPincode.builder().id(133L).name("Kizhuvalam").nameInLocal("കിഴുവലം").pincode("695104").status(true).build());
//        mPincodes.add(MPincode.builder().id(134L).name("Kochuvila").nameInLocal("കൊച്ചുവിള").pincode("695563").status(true).build());
//        mPincodes.add(MPincode.builder().id(135L).name("Kodithookiyakunnu").nameInLocal("കൊടിതൂക്കിയകുന്ന്").pincode("695608").status(true).build());
//        mPincodes.add(MPincode.builder().id(136L).name("Kodunganur").nameInLocal("കൊടുങ്ങാനൂർ").pincode("695013").status(true).build());
//        mPincodes.add(MPincode.builder().id(137L).name("Kodungavila").nameInLocal("കൊടുങ്ങാവിള").pincode("695123").status(true).build());
//        mPincodes.add(MPincode.builder().id(138L).name("Koduvazhannur").nameInLocal("കൊടുവഴന്നൂർ").pincode("695612").status(true).build());
//        mPincodes.add(MPincode.builder().id(139L).name("Koithurkonam").nameInLocal("കൊയ്ത്തൂർക്കോണം").pincode("695584").status(true).build());
//        mPincodes.add(MPincode.builder().id(140L).name("Kokkotela").nameInLocal("കൊക്കോട്ടെല").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(141L).name("Kokkottukonam").nameInLocal("കൊക്കോട്ടുകോണം").pincode("695604").status(true).build());
//        mPincodes.add(MPincode.builder().id(142L).name("Koliakode").nameInLocal("കോലിയക്കോട്").pincode("695607").status(true).build());
//        mPincodes.add(MPincode.builder().id(143L).name("Kollode").nameInLocal("കൊല്ലോട്").pincode("695571").status(true).build());
//        mPincodes.add(MPincode.builder().id(144L).name("Konchira").nameInLocal("കൊഞ്ചിറ").pincode("695615").status(true).build());
//        mPincodes.add(MPincode.builder().id(145L).name("Koonanvenga").nameInLocal("കൂനൻവേങ്ങ").pincode("695568").status(true).build());
//        mPincodes.add(MPincode.builder().id(146L).name("Koothali(TVM)").nameInLocal("കൂത്താളി(ടിവിഎം)").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(147L).name("Kottackal (TVM)").nameInLocal("കോട്ടക്കൽ (TVM)").pincode("695124").status(true).build());
//        mPincodes.add(MPincode.builder().id(148L).name("Kottakkakom").nameInLocal("കോട്ടക്കകം").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(149L).name("Kottapuram").nameInLocal("കോട്ടപ്പുറം").pincode("695521").status(true).build());
//        mPincodes.add(MPincode.builder().id(150L).name("Kottoor(TVM)").nameInLocal("കോട്ടൂർ(ടിവിഎം)").pincode("695574").status(true).build());
//        mPincodes.add(MPincode.builder().id(151L).name("Kottukal").nameInLocal("കോട്ടുകാൽ").pincode("695501").status(true).build());
//        mPincodes.add(MPincode.builder().id(152L).name("Kottukunnam").nameInLocal("കോട്ടുകുന്നം").pincode("695606").status(true).build());
//        mPincodes.add(MPincode.builder().id(153L).name("Kovalam Beach").nameInLocal("കോവളം ബീച്ച്").pincode("695527").status(true).build());
//        mPincodes.add(MPincode.builder().id(154L).name("Kovalam").nameInLocal("കോവളം").pincode("695527").status(true).build());
//        mPincodes.add(MPincode.builder().id(155L).name("Kudappanakunnu").nameInLocal("കുടപ്പനക്കുന്ന്").pincode("695043").status(true).build());
//        mPincodes.add(MPincode.builder().id(156L).name("Kudappanamoodu").nameInLocal("കുടപ്പനമൂട്").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(157L).name("Kudavur").nameInLocal("കുടവൂർ").pincode("695313").status(true).build());
//        mPincodes.add(MPincode.builder().id(158L).name("Kudayal").nameInLocal("കുടയാൽ").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(159L).name("Kulamuttam").nameInLocal("കുളമുട്ടം").pincode("695144").status(true).build());
//        mPincodes.add(MPincode.builder().id(160L).name("Kulappada").nameInLocal("കുളപ്പട").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(161L).name("Kulathur").nameInLocal("കുളത്തൂർ").pincode("695583").status(true).build());
//        mPincodes.add(MPincode.builder().id(162L).name("Kunnathukal").nameInLocal("കുന്നത്തുകാൽ").pincode("695504").status(true).build());
//        mPincodes.add(MPincode.builder().id(163L).name("Kurakkada").nameInLocal("കുരാക്കട").pincode("695104").status(true).build());
//        mPincodes.add(MPincode.builder().id(164L).name("Kurumbayam").nameInLocal("കുറുമ്പായം").pincode("695608").status(true).build());
//        mPincodes.add(MPincode.builder().id(165L).name("Kuruthamcode").nameInLocal("കുരുത്തംകോട്").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(166L).name("Kuthirakalam-vellanad").nameInLocal("കുതിരക്കളം-വെള്ളനാട്").pincode("695543").status(true).build());
//        mPincodes.add(MPincode.builder().id(167L).name("Kuthirakulam").nameInLocal("കുതിരകുളം").pincode("695615").status(true).build());
//        mPincodes.add(MPincode.builder().id(168L).name("Kuttamala").nameInLocal("കുട്ടമല").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(169L).name("Kuttichal").nameInLocal("കുറ്റിച്ചൽ").pincode("695574").status(true).build());
//        mPincodes.add(MPincode.builder().id(170L).name("Kuvalassery").nameInLocal("കുവളശ്ശേരി").pincode("695512").status(true).build());
//        mPincodes.add(MPincode.builder().id(171L).name("Lourdepuram").nameInLocal("ലൂർദാപുരം").pincode("695526").status(true).build());
//        mPincodes.add(MPincode.builder().id(172L).name("Machel").nameInLocal("മാഷേൽ").pincode("695571").status(true).build());
//        mPincodes.add(MPincode.builder().id(173L).name("Madavoor-pallickal").nameInLocal("മടവൂർ-പള്ളിക്കൽ").pincode("695602").status(true).build());
//        mPincodes.add(MPincode.builder().id(174L).name("Malakkal").nameInLocal("മാലക്കൽ").pincode("695602").status(true).build());
//        mPincodes.add(MPincode.builder().id(175L).name("Malayam").nameInLocal("മലയം").pincode("695571").status(true).build());
//        mPincodes.add(MPincode.builder().id(176L).name("Malayinkil").nameInLocal("മലയിങ്കിൽ").pincode("695571").status(true).build());
//        mPincodes.add(MPincode.builder().id(177L).name("Manacaud").nameInLocal("മണക്കാട്").pincode("695009").status(true).build());
//        mPincodes.add(MPincode.builder().id(178L).name("Manali").nameInLocal("മണാലി").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(179L).name("Manambur").nameInLocal("മണമ്പൂർ").pincode("695611").status(true).build());
//        mPincodes.add(MPincode.builder().id(180L).name("Mancha").nameInLocal("മഞ്ച").pincode("695541").status(true).build());
//        mPincodes.add(MPincode.builder().id(181L).name("Manchamcode").nameInLocal("മഞ്ചാംകോട്").pincode("695125").status(true).build());
//        mPincodes.add(MPincode.builder().id(182L).name("Manchavilakom").nameInLocal("മഞ്ചവിളകം").pincode("695503").status(true).build());
//        mPincodes.add(MPincode.builder().id(183L).name("Manikanteswaram").nameInLocal("മണികണ്ഠേശ്വരം").pincode("695013").status(true).build());
//        mPincodes.add(MPincode.builder().id(184L).name("Manjamala").nameInLocal("മഞ്ഞമല").pincode("695313").status(true).build());
//        mPincodes.add(MPincode.builder().id(185L).name("Mannamkonam").nameInLocal("മണ്ണാംകോണം").pincode("695125").status(true).build());
//        mPincodes.add(MPincode.builder().id(186L).name("Mannanathala").nameInLocal("മണ്ണനത്തല").pincode("695015").status(true).build());
//        mPincodes.add(MPincode.builder().id(187L).name("Mannurkonam").nameInLocal("മണ്ണൂർക്കോണം").pincode("695541").status(true).build());
//        mPincodes.add(MPincode.builder().id(188L).name("Marangad").nameInLocal("മരങ്ങാട്").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(189L).name("Marayamuttom").nameInLocal("മാരായമുട്ടം").pincode("695124").status(true).build());
//        mPincodes.add(MPincode.builder().id(190L).name("Mariyapuram").nameInLocal("മരിയാപുരം").pincode("695122").status(true).build());
//        mPincodes.add(MPincode.builder().id(191L).name("Maruthamala").nameInLocal("മരുതമല").pincode("695551").status(true).build());
//        mPincodes.add(MPincode.builder().id(192L).name("Maruthikunnu").nameInLocal("മരുതിക്കുന്ന്").pincode("695603").status(true).build());
//        mPincodes.add(MPincode.builder().id(193L).name("Mayam").nameInLocal("മായം").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(194L).name("Meenankal").nameInLocal("മീനാങ്കൽ").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(195L).name("Meenmutty").nameInLocal("മീൻമുട്ടി").pincode("695562").status(true).build());
//        mPincodes.add(MPincode.builder().id(196L).name("Melkadakkavur").nameInLocal("മേൽക്കടക്കാവൂർ").pincode("695306").status(true).build());
//        mPincodes.add(MPincode.builder().id(197L).name("Melvettoor").nameInLocal("മേൽവെട്ടൂർ").pincode("695312").status(true).build());
//        mPincodes.add(MPincode.builder().id(198L).name("Melvettoor").nameInLocal("മേൽവെട്ടൂർ").pincode("695312").status(true).build());
//        mPincodes.add(MPincode.builder().id(199L).name("Memala").nameInLocal("മേമല").pincode("695551").status(true).build());
//        mPincodes.add(MPincode.builder().id(200L).name("Mg College").nameInLocal("എംജി കോളേജ്").pincode("695004").status(true).build());
//        mPincodes.add(MPincode.builder().id(201L).name("Mithirmala").nameInLocal("മിതിർമ്മല").pincode("695610").status(true).build());
//        mPincodes.add(MPincode.builder().id(202L).name("Mithraniketan").nameInLocal("മിത്രനികേതൻ").pincode("695543").status(true).build());
//        mPincodes.add(MPincode.builder().id(203L).name("Moongode").nameInLocal("മൂങ്ങോട്").pincode("695573").status(true).build());
//        mPincodes.add(MPincode.builder().id(204L).name("Moongode").nameInLocal("മൂങ്ങോട്").pincode("695144").status(true).build());
//        mPincodes.add(MPincode.builder().id(205L).name("Moonnanakuzhy").nameInLocal("മൂന്നാനക്കുഴി").pincode("695615").status(true).build());
//        mPincodes.add(MPincode.builder().id(206L).name("Moonnumukku").nameInLocal("മൂന്നുമുക്ക്").pincode("695609").status(true).build());
//        mPincodes.add(MPincode.builder().id(207L).name("Moothala").nameInLocal("മൂത്തല").pincode("695604").status(true).build());
//        mPincodes.add(MPincode.builder().id(208L).name("Mudakkal").nameInLocal("മുദാക്കൽ").pincode("695103").status(true).build());
//        mPincodes.add(MPincode.builder().id(209L).name("Mudapuram").nameInLocal("മുടപുരം").pincode("695304").status(true).build());
//        mPincodes.add(MPincode.builder().id(210L).name("Mukkolackal").nameInLocal("മുക്കോലക്കൽ").pincode("695043").status(true).build());
//        mPincodes.add(MPincode.builder().id(211L).name("Mukkudil").nameInLocal("മുക്കുടിൽ").pincode("695607").status(true).build());
//        mPincodes.add(MPincode.builder().id(212L).name("Mulakkalathukavu").nameInLocal("മുളക്കലത്തുകാവ്").pincode("695614").status(true).build());
//        mPincodes.add(MPincode.builder().id(213L).name("Mulayara").nameInLocal("മുളയറ").pincode("695543").status(true).build());
//        mPincodes.add(MPincode.builder().id(214L).name("Mullur").nameInLocal("മുള്ളൂർ").pincode("695521").status(true).build());
//        mPincodes.add(MPincode.builder().id(215L).name("Mulluvila").nameInLocal("മുള്ളുവിള").pincode("695133").status(true).build());
//        mPincodes.add(MPincode.builder().id(216L).name("Mundela").nameInLocal("മുണ്ടേല").pincode("695543").status(true).build());
//        mPincodes.add(MPincode.builder().id(217L).name("Murukumpuzhaa").nameInLocal("മുരുക്കുംപുഴ").pincode("695302").status(true).build());
//        mPincodes.add(MPincode.builder().id(218L).name("Muthana").nameInLocal("മുത്താന").pincode("695146").status(true).build());
//        mPincodes.add(MPincode.builder().id(219L).name("Muthuvila").nameInLocal("മുതുവിള").pincode("695610").status(true).build());
//        mPincodes.add(MPincode.builder().id(220L).name("Muttada").nameInLocal("മുട്ടട").pincode("695025").status(true).build());
//        mPincodes.add(MPincode.builder().id(221L).name("Muttakadu").nameInLocal("മുട്ടക്കാട്").pincode("695523").status(true).build());
//        mPincodes.add(MPincode.builder().id(222L).name("Muttappalam").nameInLocal("മുട്ടപ്പലം").pincode("695145").status(true).build());
//        mPincodes.add(MPincode.builder().id(223L).name("Mylakkara").nameInLocal("മൈലക്കര").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(224L).name("Mylamoodu").nameInLocal("മൈലമൂട്").pincode("695609").status(true).build());
//        mPincodes.add(MPincode.builder().id(225L).name("Nagaroor").nameInLocal("നഗരൂർ").pincode("695601").status(true).build());
//        mPincodes.add(MPincode.builder().id(226L).name("Nalanchira").nameInLocal("നാലാഞ്ചിറ").pincode("695015").status(true).build());
//        mPincodes.add(MPincode.builder().id(227L).name("Naruvamoodu").nameInLocal("നരുവാമൂട്").pincode("695528").status(true).build());
//        mPincodes.add(MPincode.builder().id(228L).name("Navaikulam").nameInLocal("നാവായിക്കുളം").pincode("695603").status(true).build());
//        mPincodes.add(MPincode.builder().id(229L).name("Nedumangad").nameInLocal("നെടുമങ്ങാട്").pincode("695541").status(true).build());
//        mPincodes.add(MPincode.builder().id(230L).name("Nedumparambu").nameInLocal("നെടുംപറമ്പ്").pincode("695102").status(true).build());
//        mPincodes.add(MPincode.builder().id(231L).name("Nedunganda").nameInLocal("നെടുങ്കണ്ട").pincode("695307").status(true).build());
//        mPincodes.add(MPincode.builder().id(232L).name("Neeramankadavuu").nameInLocal("നീറമൺകടവ്").pincode("695610").status(true).build());
//        mPincodes.add(MPincode.builder().id(233L).name("Nellanad").nameInLocal("നെല്ലനാട്").pincode("695606").status(true).build());
//        mPincodes.add(MPincode.builder().id(234L).name("Nellimoodu").nameInLocal("നെല്ലിമൂട്").pincode("695524").status(true).build());
//        mPincodes.add(MPincode.builder().id(235L).name("Nellivila").nameInLocal("നെല്ലിവിള").pincode("695523").status(true).build());
//        mPincodes.add(MPincode.builder().id(236L).name("Nemom").nameInLocal("നേമം").pincode("695020").status(true).build());
//        mPincodes.add(MPincode.builder().id(237L).name("Nethajipuram").nameInLocal("നേതാജിപുരം").pincode("695589").status(true).build());
//        mPincodes.add(MPincode.builder().id(238L).name("Nettayam").nameInLocal("നെട്ടയം").pincode("695013").status(true).build());
//        mPincodes.add(MPincode.builder().id(239L).name("Neyyar Dam").nameInLocal("നെയ്യാർ ഡാം").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(240L).name("Neyyattinkara").nameInLocal("നെയ്യാറ്റിൻകര").pincode("695121").status(true).build());
//        mPincodes.add(MPincode.builder().id(241L).name("Neyyattinkara Town").nameInLocal("നെയ്യാറ്റിൻകര ടൗൺ").pincode("695121").status(true).build());
//        mPincodes.add(MPincode.builder().id(242L).name("Nilakkamukku").nameInLocal("നിലയ്ക്കാമുക്ക്").pincode("695306").status(true).build());
//        mPincodes.add(MPincode.builder().id(243L).name("Njarayilkonam").nameInLocal("ഞാറയിൽകോണം").pincode("695602").status(true).build());
//        mPincodes.add(MPincode.builder().id(244L).name("Odayam").nameInLocal("ഓടയം").pincode("695311").status(true).build());
//        mPincodes.add(MPincode.builder().id(245L).name("Olathanni").nameInLocal("ഓലത്താന്നി").pincode("695133").status(true).build());
//        mPincodes.add(MPincode.builder().id(246L).name("Ookode").nameInLocal("ഊക്കോട്").pincode("695020").status(true).build());
//        mPincodes.add(MPincode.builder().id(247L).name("Oorupoika").nameInLocal("ഊരുപൊയ്ക").pincode("695104").status(true).build());
//        mPincodes.add(MPincode.builder().id(248L).name("Ooruttambalam").nameInLocal("ഊരൂട്ടമ്പലം").pincode("695507").status(true).build());
//        mPincodes.add(MPincode.builder().id(249L).name("Ottasekharamangalam").nameInLocal("ഒറ്റശേഖരമംഗലം").pincode("695125").status(true).build());
//        mPincodes.add(MPincode.builder().id(250L).name("Pacha").nameInLocal("പച്ച").pincode("695562").status(true).build());
//        mPincodes.add(MPincode.builder().id(251L).name("Pachallur").nameInLocal("പാച്ചല്ലൂർ").pincode("695027").status(true).build());
//        mPincodes.add(MPincode.builder().id(252L).name("Pakalkuri").nameInLocal("പകൽക്കുറി").pincode("695604").status(true).build());
//        mPincodes.add(MPincode.builder().id(253L).name("Palachira").nameInLocal("പാലച്ചിറ").pincode("695143").status(true).build());
//        mPincodes.add(MPincode.builder().id(254L).name("Palamkonam").nameInLocal("പാലാംകോണം").pincode("695607").status(true).build());
//        mPincodes.add(MPincode.builder().id(255L).name("Palayamkunnu").nameInLocal("പാളയംകുന്ന്").pincode("695146").status(true).build());
//        mPincodes.add(MPincode.builder().id(256L).name("Palkulangara").nameInLocal("പാൽക്കുളങ്ങര").pincode("695024").status(true).build());
//        mPincodes.add(MPincode.builder().id(257L).name("Pallichal").nameInLocal("പള്ളിച്ചൽ").pincode("695020").status(true).build());
//        mPincodes.add(MPincode.builder().id(258L).name("Pallickal Kilimanur").nameInLocal("പള്ളിക്കൽ കിളിമാനൂർ").pincode("695604").status(true).build());
//        mPincodes.add(MPincode.builder().id(259L).name("Pallipuram").nameInLocal("പള്ളിപ്പുറം").pincode("695316").status(true).build());
//        mPincodes.add(MPincode.builder().id(260L).name("Pallithura").nameInLocal("പള്ളിത്തുറ").pincode("695586").status(true).build());
//        mPincodes.add(MPincode.builder().id(261L).name("Paluvally").nameInLocal("പാലുവള്ളി").pincode("695562").status(true).build());
//        mPincodes.add(MPincode.builder().id(262L).name("Panachamoodu").nameInLocal("പനച്ചമൂട്").pincode("695505").status(true).build());
//        mPincodes.add(MPincode.builder().id(263L).name("Panacode").nameInLocal("പനകോഡ്").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id(264L).name("Panangode").nameInLocal("പനങ്ങോട്").pincode("695563").status(true).build());
//        mPincodes.add(MPincode.builder().id(265L).name("Panavoor").nameInLocal("പനവൂർ").pincode("695568").status(true).build());
//        mPincodes.add(MPincode.builder().id(266L).name("Panayam").nameInLocal("പനയം").pincode("695568").status(true).build());
//        mPincodes.add(MPincode.builder().id(267L).name("Panayamuttom").nameInLocal("പനയമുട്ടം").pincode("695561").status(true).build());
//        mPincodes.add(MPincode.builder().id(268L).name("Panayara").nameInLocal("പനയറ").pincode("695145").status(true).build());
//        mPincodes.add(MPincode.builder().id(269L).name("Pandalacode").nameInLocal("പന്തലക്കോട്").pincode("695028").status(true).build());
//        mPincodes.add(MPincode.builder().id(270L).name("Pangappara").nameInLocal("പാങ്ങപ്പാറ").pincode("695581").status(true).build());
//        mPincodes.add(MPincode.builder().id(271L).name("Panode").nameInLocal("പാനോട്").pincode("695609").status(true).build());
//        mPincodes.add(MPincode.builder().id(272L).name("Panniyode").nameInLocal("പന്നിയോട്").pincode("695575").status(true).build());
//        mPincodes.add(MPincode.builder().id(273L).name("Pantha").nameInLocal("പാന്ത").pincode("695572").status(true).build());
//        mPincodes.add(MPincode.builder().id(274L).name("Pappanamcode").nameInLocal("പാപ്പനംകോട്").pincode("695018").status(true).build());
//        mPincodes.add(MPincode.builder().id(275L).name("Parakunnu").nameInLocal("പാറക്കുന്ന്").pincode("695603").status(true).build());
//        mPincodes.add(MPincode.builder().id(276L).name("Parandode").nameInLocal("പറണ്ടോട്").pincode("695542").status(true).build());
//        mPincodes.add(MPincode.builder().id
//        masterDataService.createPincodes(mPincodes);
//    }

    @Autowired
    private MDistrictRepository districtRepository;
    @Autowired
    private MPincodeRepository pincodeRepository;
//    @Autowired
//    private CarRepository carRepository;

    @Transactional
    public void initData(MultipartFile districtsFile, MultipartFile pincodesFile, MultipartFile carsFile) throws IOException {

        // Process Districts if file is present and not empty
        if (districtsFile != null && !districtsFile.isEmpty()) {
            List<MDistrict> districts = ExcelUtility.excelToDistricts(districtsFile.getInputStream());
            for (MDistrict district : districts) {
                districtRepository.findByExcelId(district.getExcelId())
                        .ifPresentOrElse(existingObj -> {
                            MDistrict existing = (MDistrict) existingObj; // Cast to MDistrict
                            existing.setName(district.getName());
                            existing.setNameInLocal(district.getNameInLocal());
                            existing.setStatus(district.isStatus());
                            districtRepository.save(existing);
                        }, () -> {
                            // New district entry
                            district.setId(null); // Let UUID be auto-generated
                            districtRepository.save(district);
                        });
            }
        }

// Process Pincodes if file is present and not empty
        if (pincodesFile != null && !pincodesFile.isEmpty()) {
            List<MPincode> pincodes = ExcelUtility.excelToPincodes(pincodesFile.getInputStream());
            for (MPincode pincode : pincodes) {
                pincodeRepository.findByExcelId(pincode.getExcelId())
                        .ifPresentOrElse(existingObj -> {
                            MPincode existing = (MPincode) existingObj; // Cast to MPincode
                            existing.setName(pincode.getName());
                            existing.setNameInLocal(pincode.getNameInLocal());
                            existing.setPincode(pincode.getPincode());
                            existing.setStatus(pincode.isStatus());
                            pincodeRepository.save(existing);
                        }, () -> {
                            // New pincode entry
                            pincode.setId(null); // Let UUID be auto-generated
                            pincodeRepository.save(pincode);
                        });
            }
        }



        // Process Cars if file is present and not empty
//    if (carsFile != null && !carsFile.isEmpty()) {
//        List<Car> cars = ExcelUtility.excelToCars(carsFile.getInputStream());
//        for (Car car : cars) {
//            carRepository.findById(car.getId())
//                    .ifPresentOrElse(existing -> {
//                        existing.setModel(car.getModel());
//                        existing.setBrand(car.getBrand());
//                        existing.setPincode(car.getPincode());
//                        existing.setStatus(car.isStatus());
//                        carRepository.save(existing);
//                    }, () -> carRepository.save(car));
//        }
//    }
    }
}
