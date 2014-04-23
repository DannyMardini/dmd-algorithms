function m (img,action) {
  if(document.images) {
    if(action == 1) {
      document.images[img].src = '/images/wsarrow.gif';
    } else {
      document.images[img].src = '/images/wharrow.gif';
    }
  }
}

function mIn (img, doA) {
  if (document.images) {
    if (doA) {
      document.images[img].src = "/images/arrow.gif";
      if(document.images[img+'_']) {
        document.images[img + '_'].src = "/images/rarrow.gif";
      }     
    }
  }

} // mIn()


function mOut (img, doA) {
  if (document.images) {
    if (doA) {
      document.images[img].src = "/images/noarrow.gif";
      if(document.images[img+'_']) {
        document.images[img + '_'].src = "/images/noarrow.gif";
      }
    }
  }

} // mOut()
