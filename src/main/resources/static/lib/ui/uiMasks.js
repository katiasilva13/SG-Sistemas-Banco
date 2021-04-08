angular.module("uiMasks", []);

angular.module("uiMasks").directive("uiDate", function () {
  return {
    require: "ngModel",
    link: function (scope, element, attrs, ctrl) {
      var _formatDate = function (date) {
        date = date.replace(/[^0-9]+/g, "");
        if (date.length > 2) {
          date = date.substring(0, 2) + "/" + date.substring(2);
        }
        if (date.length > 5) {
          date = date.substring(0, 5) + "/" + date.substring(5, 9);
        }
        return date;
      };

      element.bind("keyup", function () {
        ctrl.$setViewValue(_formatDate(ctrl.$viewValue));
        ctrl.$render();
      });
    },
  };
});

angular.module("uiMasks").directive("uiPhoneNumber", function () {
  return {
    require: "ngModel",
    link: function (scope, element, attrs, ctrl) {
      var _formatPhoneNumber = function (phoneNumber) {
        phoneNumber = phoneNumber.replace(/[^0-9]+/g, "");
        if (phoneNumber.length > 2) {
          phoneNumber = "(" + phoneNumber.substring(0, 2) + ")" + phoneNumber.substring(2);
        }
        if (phoneNumber.length > 9) {
          phoneNumber = phoneNumber.substring(0, 9) + "-" + phoneNumber.substring(9,13);
        }
        return phoneNumber;
      };

      element.bind("keyup", function () {
        ctrl.$setViewValue(_formatPhoneNumber(ctrl.$viewValue));
        ctrl.$render();
      });
    }
  };
});
